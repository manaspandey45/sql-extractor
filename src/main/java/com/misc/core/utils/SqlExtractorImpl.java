package com.misc.core.utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;

public class SqlExtractorImpl {

	public void extractSql(final String folderPath) {
		final List<File> files = new ArrayList<>();
		listFiles(folderPath, files);
		SQLExtractorConstants.REGEX_MAP.forEach((k, v) -> {
			try {
				extractSqls(files, v, k);
			} catch (final IOException e) {

				e.printStackTrace();
			}
		});

	}

	public void listFiles(final String directoryName, final List<File> files) {
		final File directory = new File(directoryName);

		// Get all files from a directory.
		final File[] fList = directory.listFiles();
		if (fList != null) {
			for (final File file : fList) {
				if (file.isFile() && "java".equalsIgnoreCase(FilenameUtils.getExtension(file.toString()))) {
					files.add(file);
				} else if (file.isDirectory()) {
					listFiles(file.getAbsolutePath(), files);
				}
			}
		}
	}

	private void extractSqls(final List<File> files, final String regex, final String type) throws IOException {
		final File opFile = new File(type + "_SQLS.txt");

		for (final File file : files) {
			String content = FileUtils.readFileToString(file, StandardCharsets.UTF_8);
			content = content.replace("\n", "").replace("\r", "");
			content = content.replace(";", ";\n");
			final Pattern pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
			final Matcher matcher = pattern.matcher(content);
			while (matcher.find()) {

				FileUtils.writeStringToFile(opFile,
						matcher.group().replaceAll("\\s+", " ").replaceAll("\\+", "").replaceAll("\"", "") + "\n",
						StandardCharsets.UTF_8, true);

			}

		}

	}
}
