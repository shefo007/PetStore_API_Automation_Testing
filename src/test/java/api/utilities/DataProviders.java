package api.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    @DataProvider(name = "Data")
    public Object[][] getAllData() throws IOException {
        String path = "testData/Swagger_Petstore_UserData.xlsx";
        XLUtility xl = new XLUtility(path);

        int rowNum = xl.getRowCount("Sheet1");
        int colNum = xl.getCellCount("Sheet1", 1);

        String[][] apiData = new String[rowNum][colNum];

        for (int i = 1; i <= rowNum; i++) {
            for (int j = 0; j < colNum; j++) {
                apiData[i - 1][j] = xl.getCellData("Sheet1", i, j);
            }
        }

        return apiData;
    }

    @DataProvider(name = "UserNames")
    public String[] getUserNames() throws IOException {

        String path = "testData/Swagger_Petstore_UserData.xlsx";
        XLUtility xl = new XLUtility(path);

        int rowNum = xl.getRowCount("Sheet1");

        String[] apiData = new String[rowNum];

        for (int i = 1; i <= rowNum; i++) {
            apiData[i - 1] = xl.getCellData("Sheet1", i, 1);
        }

        return  apiData;
    }
}
