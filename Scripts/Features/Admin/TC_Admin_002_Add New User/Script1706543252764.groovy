import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Features/Admin/TC_Admin_001_Access Admin Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Admin Menu/User Management/Users/button_Add_User'))

WebUI.verifyElementPresent(findTestObject('Admin Menu/User Management/Users/Add User/h6_Add User'), 0)

WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/dropdown_Roles'))

WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Admin'))

WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/dropdown_Statuses'))

WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Enabled'))

WebUI.setText(findTestObject('Admin Menu/User Management/Users/Add User/input_Employee_Name'), GlobalVariable.EMPLOYEE_NAME)

WebUI.waitForElementVisible(findTestObject('Admin Menu/User Management/Users/div_Odis Adalwin'), 5)

WebUI.verifyElementVisible(findTestObject('Admin Menu/User Management/Users/Add User/div_Employee Name'), FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Employee Name'))

WebUI.setText(findTestObject('Admin Menu/User Management/Users/Add User/input_Username'), GlobalVariable.USERNAME)

WebUI.setText(findTestObject('Admin Menu/User Management/Users/Add User/input_Password'), GlobalVariable.PASSWORD)

WebUI.setText(findTestObject('Admin Menu/User Management/Users/Add User/input_Confirm Password'), GlobalVariable.PASSWORD)

WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/button_Save'))

WebUI.verifyElementPresent(findTestObject('Admin Menu/User Management/Users/Add User/popup_SuccessSuccessfully Saved'), 
    0)

