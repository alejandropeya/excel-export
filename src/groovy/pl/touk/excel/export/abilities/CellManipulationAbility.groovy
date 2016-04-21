package pl.touk.excel.export.abilities
import org.apache.poi.ss.usermodel.Sheet
import org.apache.poi.ss.util.CellUtil
import org.apache.poi.xssf.streaming.SXSSFCell
import org.apache.poi.xssf.streaming.SXSSFRow
import pl.touk.excel.export.getters.Getter
import pl.touk.excel.export.multisheet.SheetManipulator

@Category(SheetManipulator)
class CellManipulationAbility {
    SXSSFCell getCellAt(int rowNumber, int columnNumber) {
        SXSSFRow row = CellManipulationAbility.getOrCreateRow(rowNumber, sheet)
        row.getCell((Short) columnNumber)
    }

    SheetManipulator putCellValue(int rowNumber, int columnNumber, String value) {
        CellManipulationAbility.getOrCreateCellAt(rowNumber, columnNumber, sheet).setCellValue(getCreationHelper().createRichTextString(value))
        return this
    }

    SheetManipulator putCellValue(int rowNumber, int columnNumber, Getter formatter) {
        CellManipulationAbility.putCellValue(rowNumber, columnNumber, formatter.propertyName)
        return this
    }

    SheetManipulator putCellValue(int rowNumber, int columnNumber, Number value) {
        CellManipulationAbility.getOrCreateCellAt(rowNumber, columnNumber, sheet).setCellValue(value.toDouble())
        return this
    }

    SheetManipulator putCellValue(int rowNumber, int columnNumber, Date value) {
        SXSSFCell cell = CellManipulationAbility.getOrCreateCellAt(rowNumber, columnNumber, sheet)
        cell.setCellValue(value)
        cell.setCellStyle(dateCellStyle)
        return this
    }

    SheetManipulator putCellValue(int rowNumber, int columnNumber, Boolean value) {
        CellManipulationAbility.getOrCreateCellAt(rowNumber, columnNumber, sheet).setCellValue(value)
        return this
    }

    private static SXSSFCell getOrCreateCellAt(int rowNumber, int columnNumber, Sheet sheet) {
        (SXSSFCell) CellUtil.getCell(getOrCreateRow(rowNumber, sheet), columnNumber)
    }

    private static SXSSFRow getOrCreateRow(int rowNumber, Sheet sheet) {
        (SXSSFRow) CellUtil.getRow(rowNumber, sheet)
    }
}
