package vntrieu.train.bdsbackend.ExcelExport;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import vntrieu.train.bdsbackend.dto.ProductDTO;


public class ProductExcelExporter {
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private List<ProductDTO> listProducts;

    public ProductExcelExporter(List<ProductDTO> listProducts) {
        this.listProducts = listProducts;
        workbook = new XSSFWorkbook();
    }


    private void writeHeaderLine() {
        sheet = workbook.createSheet("Users");

        Row row = sheet.createRow(0);

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setBold(true);
        font.setFontHeight(16);
        style.setFont(font);

        createCell(row, 0, "Id", style);
        createCell(row, 1, "Title", style);
        createCell(row, 2, "Lease", style);
        createCell(row, 3, "Price", style);
        createCell(row, 4, "Descreption", style);
        createCell(row, 5, "Address", style);
        createCell(row, 6, "Category", style);
        createCell(row, 7, "Contact", style);
        createCell(row, 8, "Frontispiece", style);
        createCell(row, 9, "Number of floors", style);
        createCell(row, 10, "Number of WC", style);
        createCell(row, 11, "Funiture", style);
        createCell(row, 12, "Legal information", style);

    }

    private void createCell(Row row, int columnCount, Object value, CellStyle style) {
        sheet.autoSizeColumn(columnCount);
        Cell cell = row.createCell(columnCount);
        if (value instanceof Integer) {
            cell.setCellValue((Integer) value);
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        }else {
            cell.setCellValue((String) value);
        }
        cell.setCellStyle(style);
    }

    private void writeDataLines() {
        int rowCount = 1;

        CellStyle style = workbook.createCellStyle();
        XSSFFont font = workbook.createFont();
        font.setFontHeight(14);
        style.setFont(font);

        for (ProductDTO p : listProducts) {
            Row row = sheet.createRow(rowCount++);
            int columnCount = 0;

            createCell(row, columnCount++, p.getId().toString(), style);
            createCell(row, columnCount++, p.getTitle(), style);
            createCell(row, columnCount++, p.getLease().toString(), style);
            createCell(row, columnCount++, p.getPrice().toString(), style);
            createCell(row, columnCount++, p.getDescreption(), style);
            createCell(row, columnCount++, p.getAddress().getAddressString(), style);
            createCell(row, columnCount++, p.getCategory().getName(), style);
            createCell(row, columnCount++, p.getPhoneNumber(), style);
            createCell(row, columnCount++, p.getFrontispiece().toString(), style);
            createCell(row, columnCount++, p.getNumberOfFloors().toString(), style);
            createCell(row, columnCount++, p.getNumberOfWC().toString(), style);
            createCell(row, columnCount++, p.getFuniture(), style);
            createCell(row, columnCount++, p.getLegalInfor(), style);

        }
    }

    public ByteArrayInputStream export() throws IOException {
        writeHeaderLine();
        writeDataLines();
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        workbook.write(out);
        return new ByteArrayInputStream(out.toByteArray());

    }
}
