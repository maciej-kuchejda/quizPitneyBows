package com.kuchejda.maciej.util;


import java.util.Date;
import java.util.List;

import flexjson.JSONDeserializer;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;
/*
 * Class used to serialize and deserialize object's to json,
 * and json to specific object's
 */
public class JsonUntil {

	private final DateTransformer _dateTransformer = new DateTransformer("yyyy-MM-dd");
	
	public String toJson(Object value)
	{
		return new JSONSerializer().transform(_dateTransformer, Date.class, java.util.Date.class).exclude("*.class").deepSerialize(value);
	}
	
	public <T> String toJsonArray(List<T> collection) 
    {
        return new JSONSerializer().transform(_dateTransformer, Date.class, java.util.Date.class).exclude("*.class").serialize(collection);
    }
	
	public <T> T fromJson(String json, Class<T> clazz) 
    {
        return new JSONDeserializer<T>().use(null, clazz).use(Date.class, _dateTransformer).deserialize(json);
    }	
}
