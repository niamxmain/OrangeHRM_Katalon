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

WebUI.callTestCase(findTestCase('Features/Admin/TC_Admin_003_Search User'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Admin_Menu/User_Management/Users/btn_i_Enabled_oxd-icon bi-edit'))

WebUI.verifyElementPresent(findTestObject('Admin_Menu/User_Management/Users/Edit User/div_Admin'), 0)

WebUI.verifyElementPresent(findTestObject('Admin_Menu/User_Management/Users/Edit User/div_Enabled'), 0)

WebUI.verifyElementPresent(findTestObject('Admin_Menu/User_Management/Users/Edit User/input'), 0)

WebUI.verifyElementPresent(findTestObject('Admin_Menu/User_Management/Users/Edit User/input_Username_oxd-input oxd-input--focus'), 
    0)

