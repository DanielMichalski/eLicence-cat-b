package database.xls;

import model.*;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

import java.io.IOException;

import static database.xls.xls_column_names.XLSModuleColumnNames.MODULE_ID;
import static database.xls.xls_column_names.XLSModuleColumnNames.MODULE_NAME;
import static database.xls.xls_column_names.XLSQuestionColumnNames.*;

/**
 * Author: Daniel
 * Date: 05.11.13
 */
public class XLSUtil {
    public static Module getModuleFromRow(Row row) {
        int id = 0;
        String moduleName = "";

        for (int column = 0; column < 2; column++) {
            Cell tempCell = row.getCell(column);

            switch (column) {
                case MODULE_ID:
                    id = (int) tempCell.getNumericCellValue();
                    break;
                case MODULE_NAME:
                    moduleName = tempCell.getStringCellValue();
                    break;
            }
        }

        return new Module(id, moduleName);
    }

    public static StandardQuestion getStandardQuestionFromRow(Row row)
            throws IOException, InvalidFormatException {

        int points = 0;
        String question = null;
        YesNoAnswer correctAnser = null;
        int moduleId = 0;
        Module module = null;
        String mediaPath = null;
        MediaType mediaType = null;

        if (row.getCell(Q_POINTS) != null) {
            points = (int) row.getCell(Q_POINTS).getNumericCellValue();
        }
        if (row.getCell(Q_QUESTION) != null) {
            question = row.getCell(Q_QUESTION).getStringCellValue();
        }
        if (row.getCell(Q_CORRECT_ANSWER) != null) {
            correctAnser = YesNoAnswer.valueOf(row.getCell(Q_CORRECT_ANSWER).getStringCellValue());
        }
        if (row.getCell(Q_MODULE) != null) {
            moduleId = (int) row.getCell(Q_MODULE).getNumericCellValue();
            module = XLSModuleDataProvider.getModuleFromModuleId(moduleId);
        }

        if (row.getCell(Q_FIRST_MEDIA_PATH) != null) {
            mediaPath = row.getCell(Q_FIRST_MEDIA_PATH).getStringCellValue();
        } else if (row.getCell(Q_SECOND_MEDIA_PATH) != null) {
            mediaPath = row.getCell(Q_SECOND_MEDIA_PATH).getStringCellValue();
        }

        if (row.getCell(Q_MEDIA_TYPE) != null) {
            mediaType = MediaType.valueOf(row.getCell(Q_MEDIA_TYPE).getStringCellValue());
        }

        return new StandardQuestion(
                points,
                question,
                null,
                correctAnser,
                module,
                mediaPath,
                mediaType
        );
    }

    public static SpecialistQuestion getSpecialistQuestionFromRow(Row row)
            throws IOException, InvalidFormatException {

        int points = 0;
        String question = null;
        String answerA = null;
        String answerB = null;
        String answerC = null;
        ABCAnswer correctAnser = null;
        int moduleId;
        Module module = null;
        String mediaPath = null;
        MediaType mediaType = null;

        if (row.getCell(3) != null) {
            points = (int) row.getCell(3).getNumericCellValue();
        }
        if (row.getCell(4) != null) {
            question = row.getCell(4).getStringCellValue();
        }
        if (row.getCell(5) != null) {
            answerA = row.getCell(5).getStringCellValue();
        }
        if (row.getCell(6) != null) {
            answerB = row.getCell(6).getStringCellValue();
        }
        if (row.getCell(7) != null) {
            answerC = row.getCell(7).getStringCellValue();
        }
        if (row.getCell(8) != null) {
            correctAnser = ABCAnswer.valueOf(row.getCell(8).getStringCellValue());
        }
        if (row.getCell(9) != null) {
            moduleId = (int) row.getCell(9).getNumericCellValue();
            module = XLSModuleDataProvider.getModuleFromModuleId(moduleId);
        }

        if (row.getCell(12) != null) {
            mediaPath = row.getCell(12).getStringCellValue();
        } else if (row.getCell(13) != null) {
            mediaPath = row.getCell(13).getStringCellValue();
        }

        if (row.getCell(16) != null) {
            mediaType = MediaType.valueOf(row.getCell(16).getStringCellValue());
        }

        return new SpecialistQuestion(
                points,
                question,
                answerA,
                answerB,
                answerC,
                null,
                correctAnser,
                module,
                mediaPath,
                mediaType
        );

    }
}

