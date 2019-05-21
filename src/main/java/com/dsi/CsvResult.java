package com.dsi;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import com.opencsv.CSVWriter;

public class CsvResult {

	public void resultInFile(List<Map<String, String>> resultList) throws IOException {
		String fileLocation = "testResult/sample.csv";
		File file = new File(fileLocation);
		FileWriter pw = new FileWriter(file);
		CSVWriter writer = new CSVWriter(pw);
		String[] header = { "ID", "Result" };
		writer.writeNext(header);
		for (Map<String, String> map : resultList) {
			String[] result = { map.get("id"), map.get("result") };
			writer.writeNext(result);
		}

		writer.close();
	}

}
