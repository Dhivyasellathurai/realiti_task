package com.example.realiti_task.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.example.realiti_task.entity.Block;
import com.example.realiti_task.entity.Floor;
import com.example.realiti_task.entity.Unit;
import com.example.realiti_task.entity.UnitView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UnitTransform {

	public static void main(String[] args) throws Exception {
		String value = "[\r\n" + "  {\r\n" + "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 1,\r\n"
				+ "    \"blocknumber\": 1,\r\n" + "    \"available\": true,\r\n"
				+ "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n" + "  },\r\n" + "  {\r\n"
				+ "    \"unitnumber\": 5,\r\n" + "    \"floornumber\": 1,\r\n" + "    \"blocknumber\": 1,\r\n"
				+ "    \"available\": true,\r\n" + "    \"modelUuid\": \"7780ae3a-e2d1-4dcf-935f-7f00eeed182d\"\r\n"
				+ "  },\r\n" + "  {\r\n" + "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 3,\r\n"
				+ "    \"blocknumber\": 1,\r\n" + "    \"available\": true,\r\n"
				+ "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n" + "  },\r\n" + "    {\r\n"
				+ "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 4,\r\n" + "    \"blocknumber\": 1,\r\n"
				+ "    \"available\": true,\r\n" + "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n"
				+ "  },\r\n" + "      {\r\n" + "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 5,\r\n"
				+ "    \"blocknumber\": 1,\r\n" + "    \"available\": true,\r\n"
				+ "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n" + "  },\r\n" + "      {\r\n"
				+ "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 3,\r\n" + "    \"blocknumber\": 6,\r\n"
				+ "    \"available\": true,\r\n" + "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n"
				+ "  },\r\n" + "      {\r\n" + "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 4,\r\n"
				+ "    \"blocknumber\": 6,\r\n" + "    \"available\": true,\r\n"
				+ "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n" + "    },\r\n" + "      {\r\n"
				+ "    \"unitnumber\": 5,\r\n" + "    \"floornumber\": 4,\r\n" + "    \"blocknumber\": 6,\r\n"
				+ "    \"available\": true,\r\n" + "    \"modelUuid\": \"7780ae3a-e2d1-4dcf-935f-7f00eeed182d\"\r\n"
				+ "    },\r\n" + "      {\r\n" + "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 5,\r\n"
				+ "    \"blocknumber\": 6,\r\n" + "    \"available\": true,\r\n"
				+ "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n" + "    },\r\n" + "      {\r\n"
				+ "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 3,\r\n" + "    \"blocknumber\": 8,\r\n"
				+ "    \"available\": true,\r\n" + "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n"
				+ "    },\r\n" + "      {\r\n" + "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 4,\r\n"
				+ "    \"blocknumber\": 8,\r\n" + "    \"available\": true,\r\n"
				+ "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n" + "    },\r\n" + "      {\r\n"
				+ "    \"unitnumber\": 4,\r\n" + "    \"floornumber\": 5,\r\n" + "    \"blocknumber\": 8,\r\n"
				+ "    \"available\": true,\r\n" + "    \"modelUuid\": \"6644235e-e2d1-4dcf-935f-7f00eeed182d\"\r\n"
				+ "    }\r\n" + "]";
		ObjectMapper objectMapper = new ObjectMapper();

		List<Unit> units = objectMapper.readValue(value, new TypeReference<List<Unit>>() {
		});
		System.out.println(changeJson(units));

	}

	public static String changeJson(List<Unit> units) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();

		Map<Integer, Map<Integer, List<UnitView>>> groupedUnits = new HashMap<>();

		for (Unit unit : units) {
			int blockNumber = unit.getBlocknumber();
			int floorNumber = unit.getFloornumber();

			Map<Integer, List<UnitView>> floorsMap = groupedUnits.get(blockNumber);
			if (floorsMap == null) {
				floorsMap = new HashMap<>();
				groupedUnits.put(blockNumber, floorsMap);
			}

			List<UnitView> unitsList = floorsMap.get(floorNumber);
			if (unitsList == null) {
				unitsList = new ArrayList<>();
				floorsMap.put(floorNumber, unitsList);
			}
			UnitView unit2 = new UnitView();
			unit2.setAvailable(unit.isAvailable());
			unit2.setUnitnumber(unit.getUnitnumber());
			unit2.setModelUuid(unit.getModelUuid());

			unitsList.add(unit2);
		}

		List<Block> blocks = new ArrayList<>();
		for (Map.Entry<Integer, Map<Integer, List<UnitView>>> blockEntry : groupedUnits.entrySet()) {
			int blockNumber = blockEntry.getKey();
			Map<Integer, List<UnitView>> floorsMap = blockEntry.getValue();

			List<Floor> floors = new ArrayList<>();
			for (Map.Entry<Integer, List<UnitView>> floorEntry : floorsMap.entrySet()) {
				int floorNumber = floorEntry.getKey();
				List<UnitView> unitsList = floorEntry.getValue();

				floors.add(new Floor(unitsList, floorNumber));
			}

			blocks.add(new Block(floors, blockNumber));
		}

		return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(blocks);
	}

}
