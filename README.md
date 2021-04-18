# sql-extractor

A lot of us struggling with legacy projects and if you have a usecase to extract the sqls embedded  in java code this utility is for you.It will extract the sqls and put it onto files

## How to use

 * `` Clone this repo ``
 
 * `` mvn clean package ``
 
 * `` Go to target folder and look for sql-extractor.jar ``
 
 * `` java -jar  sql-extractor.jar <Path of your java code> ``
 
 * `` You will get the generated sql files in the bbelow pattern ``
 
 
 
 
       * SELECT_SQLS.txt
       * UPDATE_SQLS.txt
       * INSERT_SQLS.txt
       * MERGE_SQLS.txt
       * DELETE_SQLS.txt

## Enhancement

 For any new pattern please add it in [SQLExtractorConstants.java](manaspandey45/sql-extractor/blob/master/src/main/java/com/misc/core/utils/SQLExtractorConstants.java) 
