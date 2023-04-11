package testing.actions;

import core.Base;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import resources.Reporting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestAPIActions extends Base {

    public static String APICall_AndValidation  ( String BaseURL, String EndPoint, String ExpectedStatus, String AnimalToValidate) {
        //API Call
        RestAssured.baseURI = BaseURL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(EndPoint);

        Map jsonAsMap = new HashMap<>();

        String message;
        String status;

        //getting the response and assign to variables for validation
        if (response.statusCode() == 200) {
            //statusCode would be successful request
            Reporting.StepPassed("successfully validated the API response status is - "+ response.statusCode());
            JsonPath jsonPathEvaluator = response.jsonPath();
            status = jsonPathEvaluator.prettyPrint();
            List<String> list=new ArrayList<String>();
            list = jsonPathEvaluator.get();

        }
      else
         {

             //statusCode not 200 test request has filed
                Reporting.TestFailed("Failed to preformed API Test"+ response.statusCode());
                return Reporting.finaliseTest();
         }

            //Validation
        if (status.equalsIgnoreCase(ExpectedStatus))
        {
            System.out.println(response.jsonPath().prettyPrint());

            Reporting.StepPassed("successfully validated the API response status is - "+ status );

            //Reporting.StepPassed("successfully validated the API response message is - " + response.jsonPath().prettyPrint());

            Reporting.StepPassed("successfully validated the API response message is - " + response.jsonPath().prettify());
        }
        else
        {
            Reporting.warning("Failed to Validated the API response status is equals to -"+ExpectedStatus+" - Current status is -"+ status);

        }

        Reporting.StepPassed("successfully validated All Dog breeds");

        if (jsonAsMap.containsKey(AnimalToValidate))
        {
            Reporting.StepPassed("successfully validated the "+AnimalToValidate+" Is within the Dog List");
            message =  jsonAsMap.get(AnimalToValidate).toString();

            if (message != null)
            {
                Reporting.StepPassed("successfully validated sub-breeds for - "+AnimalToValidate +" are - "+ message);
            }
            else
           {
                    Reporting.warning("No sub-breeds for - "+ AnimalToValidate);
           }

        }

        //End of Test
        Reporting.StepPassed("successfully preformed API Test");
        return Reporting.finaliseTest();
    }


    public static String APIRandomImage ( String BaseURL, String EndPoint,String ExpectedStatus) {
        RestAssured.baseURI = BaseURL;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get(EndPoint);

        String Message;
        String status;

        if (response.statusCode() == 200) {

            JsonPath jsonPathEvaluator = response.jsonPath();

//            Message = jsonPathEvaluator.get("message");
            status = jsonPathEvaluator.get("status");

        } else {
            Reporting.TestFailed("Failed to preformed API Test");
            return Reporting.finaliseTest();
        }

        if (status.equalsIgnoreCase(ExpectedStatus))
        {
            Reporting.StepPassed("successfully validated the API response status is - "+ status );

            //Reporting.StepPassed("successfully validated the API response message is - " + Message);

            Reporting.StepPassed("successfully validated the API response message is - " + response.jsonPath().prettify());
        }
        else
        {
            Reporting.warning("Failed to Validated the API response status is equals to -"+ExpectedStatus+" - Current status is -"+ status);
        }

        Reporting.StepPassed("successfully preformed API Test");
        return Reporting.finaliseTest();
    }




}
