<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" 
"http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${target.rootPath}.dao.${target.parentPath}.${target.name}Dao">
	<sql id="${target.lowName}Column">
		<![CDATA[
		    ID id,
			CREATE_TIME createTime,
			UPDATE_TIME updateTime,
		    CREATE_BY createBy,
		    UPDATE_BY updateBy,
		    <@sql_fields className="${target.className}"/>
        ]]>
	</sql>

	<!--新增${target.name}-->
	<insert id="save${target.name}" parameterType="${target.name}" keyProperty="id" useGeneratedKeys="true">
		INSERT INTO ${target.tableName}
		<trim prefix="(" suffix=")" suffixOverrides=",">
			CREATE_TIME,UPDATE_TIME,
			<if test="createBy != null and createBy != ''">
				CREATE_BY,
			</if>
			<if test="updateBy != null and updateBy != ''">
				UPDATE_BY,
			</if>
			<@sql_case className="${target.className}" type=1/>
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
			NOW(),NOW(),
			<#noparse>
			<if test="createBy != null and createBy != ''">
				#{createBy,jdbcType=VARCHAR},
			</if>
			<if test="updateBy != null and updateBy != ''">
				#{updateBy,jdbcType=VARCHAR},
			</if>
			</#noparse>
			<@sql_case className="${target.className}" type=2/>
		</trim>
	</insert>

	<!-- 删除${target.name} -->
	<delete id="deleteById" parameterType="java.lang.Long">
		DELETE FROM ${target.tableName} WHERE ID<#noparse>=#{id,jdbcType=NUMERIC}</#noparse>
	</delete>

	<!--更新${target.name} -->
	<update id="update${target.name}" parameterType="${target.name}">
		UPDATE ${target.tableName}
		<set>
			UPDATE_TIME = NOW(),
			<#noparse>
			<if test="updateBy != null and updateBy != ''">
				UPDATE_BY = #{updateBy,jdbcType=VARCHAR},
			</if>
			</#noparse>
			<@sql_case className="${target.className}" type=3/>
		</set>
		WHERE ID = <#noparse>#{id,jdbcType=NUMERIC}</#noparse>
	</update>
	
	<!-- 根据主键id查询${target.name} -->
	<select id="queryById" parameterType="java.lang.Long" resultType="${target.name}">
		SELECT <include refid="${target.lowName}Column"/> FROM ${target.tableName} WHERE ID = <#noparse>#{id,jdbcType=NUMERIC}</#noparse>
	</select>
	
	<!-- 根据分页条件分页查询${target.name}信息 -->
	<select id="queryPageList" parameterType="com.qlp.core.page.Pageable" resultType="${target.name}">
		SELECT <include refid="${target.lowName}Column"/> FROM ${target.tableName} T
		<where>
			<#noparse>
			<if test="params.name != null and params.name != '' ">
		         T.NAME LIKE concat('%',#{params.name,jdbcType=VARCHAR},'%')
		    </if>
			</#noparse>
		</where>
	</select>
</mapper>