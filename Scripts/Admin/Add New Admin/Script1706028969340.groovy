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

WebUI.callTestCase(findTestCase('Admin/Access Admin Menu'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/button_Add'))

WebUI.click(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/button_Add'))

WebUI.verifyElementVisible(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/h6_Add User'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/div_-- Select --'))

WebUI.click(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/div_-- Select --'))

WebUI.click(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/div_-- Select --'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/div_-- Select --'))

WebUI.setText(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/input'), 'Odis Adalwin')

WebUI.click(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/input_oxd-input oxd-input--focus'))

WebUI.setText(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/input_oxd-input oxd-input--focus oxd-input--error'), 
    'John Doe')

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/input_oxd-input oxd-input--active'), 
    'hUKwJTbofgPU9eVlw/CnDQ==')

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/button_Save'))

WebUI.click(findTestObject('Object Repository/Page_Admin/Page_OrangeHRM/button_Save'))

WebUI.closeBrowser()

