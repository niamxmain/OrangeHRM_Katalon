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

WebUI.callTestCase(findTestCase('Features/Admin/Access Admin Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.sendKeys(findTestObject('Admin_Menu/User_Management/Users/input_Username'), GlobalVariable.USERNAME)

WebUI.click(findTestObject('Admin_Menu/User_Management/Users/dropdown_user_role'))

WebUI.click(findTestObject('Admin_Menu/User_Management/Users/span_ESS'))

WebUI.sendKeys(findTestObject('Admin_Menu/User_Management/Users/input_Employee_Name'), GlobalVariable.EMPLOYEE_NAME)

WebUI.verifyElementVisible(findTestObject('Admin_Menu/User_Management/Users/span_Odis  Adalwin'))

WebUI.click(findTestObject('Admin_Menu/User_Management/Users/span_Odis  Adalwin'))

WebUI.click(findTestObject('Admin_Menu/User_Management/Users/dropdown_status'))

WebUI.click(findTestObject('Admin_Menu/User_Management/Users/span_Disabled'))

WebUI.click(findTestObject('Admin_Menu/User_Management/Users/button_Search'))

