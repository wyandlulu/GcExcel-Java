package com.grapecity.documents.excel.examples.features.grouping;

import com.grapecity.documents.excel.IWorksheet;
import com.grapecity.documents.excel.Workbook;
import com.grapecity.documents.excel.examples.ExampleBase;

public class CreateRangeGroup extends ExampleBase {

    @Override
    public void execute(Workbook workbook) {

        IWorksheet worksheet = workbook.getWorksheets().get(0);
        //1:20 rows' outline level will be 2.
        worksheet.getRange("1:20").group();
        //1:10 rows' outline level will be 3.
        worksheet.getRange("1:10").group();

        //A:N columns' outline level will be 2.
        worksheet.getRange("A:N").group();
        //A:E columns' outline level will be 3.
        worksheet.getRange("A:E").group();

    }

}
