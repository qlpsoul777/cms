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
			
			
		</trim>
		<trim prefix="values (" suffix=")" suffixOverrides=",">
			NOW(),NOW(),
			
		</trim>
	</insert>

	<!-- 删除${target.name} -->
	<delete id="deleteById" parameterType="java.lang.Long">
		DELETE FROM ${target.tableName} WHERE ID = {id,jdbcType=NUMERIC}
	</delete>

	<!-- 修改${target.name} -->
	<update id="update${target.name}" parameterType="${target.name}">
		UPDATE ${target.tableName}
		<set>
			UPDATE_TIME = NOW(),
			<if test="updateBy != null and updateBy != ''">
				UPDATE_BY = {updateBy,jdbcType=VARCHAR},
			</if>
			
		</set>
		WHERE ID = {id,jdbcType=NUMERIC}
	</update>
	
	<!-- 根据主键id查询${target.name} -->
	<select id="queryById" parameterType="java.lang.Long" resultType="${target.name}">
		SELECT <include refid="${target.lowName}Column"/> FROM ${target.tableName} t WHERE t.ID = {id,jdbcType=NUMERIC}
	</select>
</mapper>