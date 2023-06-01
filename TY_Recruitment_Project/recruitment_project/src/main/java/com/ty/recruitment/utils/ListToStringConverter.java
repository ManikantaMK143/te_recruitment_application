package com.ty.recruitment.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import javax.persistence.AttributeConverter;

public class ListToStringConverter implements AttributeConverter<List<String>, String> {

	@Override
	public String convertToDatabaseColumn(List<String> attribute) {
		if (attribute == null || attribute.isEmpty()) {
			return "";
		}
		return StringUtils.join(attribute.toArray(), ",");
	}

	@Override
	public List<String> convertToEntityAttribute(String dbData) {
		if (dbData == null || dbData.trim().length() == 0) {
			return new ArrayList<>();
		}
		String[] split = dbData.split(",");
		return Arrays.asList(split);
	}

}
