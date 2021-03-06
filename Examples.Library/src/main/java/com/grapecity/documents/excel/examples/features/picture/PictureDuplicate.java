package com.grapecity.documents.excel.examples.features.picture;

import java.io.IOException;
import java.io.InputStream;

import com.grapecity.documents.excel.IWorksheet;
import com.grapecity.documents.excel.Workbook;
import com.grapecity.documents.excel.drawing.IShape;
import com.grapecity.documents.excel.drawing.ImageType;
import com.grapecity.documents.excel.examples.ExampleBase;

public class PictureDuplicate extends ExampleBase {

    @Override
    public void execute(Workbook workbook) {
        IWorksheet worksheet = workbook.getWorksheets().get(0);

        InputStream stream = this.getResourceStream("logo.png");
        try {
            //Create a shape in worksheet
            IShape picture = worksheet.getShapes().addPicture(stream, ImageType.PNG, 20, 20, 395, 60);

            //Duplicate picture
            IShape newPicture = picture.duplicate();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String[] getResources() {
        return new String[]{"logo.png"};
    }

}
