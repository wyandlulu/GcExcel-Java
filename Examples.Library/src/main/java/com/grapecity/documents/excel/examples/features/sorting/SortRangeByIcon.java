package com.grapecity.documents.excel.examples.features.sorting;

import java.util.GregorianCalendar;

import com.grapecity.documents.excel.IIconSetCondition;
import com.grapecity.documents.excel.IWorksheet;
import com.grapecity.documents.excel.IconSetType;
import com.grapecity.documents.excel.IconSortField;
import com.grapecity.documents.excel.SortOrder;
import com.grapecity.documents.excel.SortOrientation;
import com.grapecity.documents.excel.Workbook;
import com.grapecity.documents.excel.examples.ExampleBase;

public class SortRangeByIcon extends ExampleBase {

    @Override
    public void execute(Workbook workbook) {

        Object data = new Object[][]{
                {"Name", "City", "Birthday", "Eye color", "Weight", "Height"},
                {"Richard", "New York", new GregorianCalendar(1968, 5, 8), "Blue", 67, 165},
                {"Nia", "New York", new GregorianCalendar(1972, 6, 3), "Brown", 62, 134},
                {"Jared", "New York", new GregorianCalendar(1964, 2, 2), "Hazel", 72, 180},
                {"Natalie", "Washington", new GregorianCalendar(1972, 7, 8), "Blue", 66, 163},
                {"Damon", "Washington", new GregorianCalendar(1986, 1, 2), "Hazel", 76, 176},
                {"Angela", "Washington", new GregorianCalendar(1993, 1, 15), "Brown", 68, 145}
        };

        IWorksheet worksheet = workbook.getWorksheets().get(0);
        worksheet.getRange("A1:F7").setValue(data);
        worksheet.getRange("A:F").setColumnWidth(15);

        IIconSetCondition iconset = worksheet.getRange("F2:F7").getFormatConditions().addIconSetCondition();
        iconset.setIconSet(workbook.getIconSets().get(IconSetType.Icon3TrafficLights1));

        //green traffic light will in the top.
        worksheet.getSort().getSortFields().add(new IconSortField(worksheet.getRange("F2:F7"), workbook.getIconSets().get(IconSetType.Icon3TrafficLights1).get(2), SortOrder.Ascending));
        worksheet.getSort().setRange(worksheet.getRange("A2:F7"));
        worksheet.getSort().setOrientation(SortOrientation.Columns);
        worksheet.getSort().apply();

    }

}
