package features

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

import internal.GlobalVariable

public class Login {


	def static void login(String url, String username, String password) {

		WebUI.openBrowser(url)
		WebUI.waitForPageLoad(GlobalVariable.DELAY_TIME)
		WebUI.maximizeWindow()

		WebUI.waitForElementVisible(findTestObject('Login Page/h5_Login'), GlobalVariable.DELAY_TIME)

		WebUI.sendKeys(findTestObject('Login Page/input_Username'), username)
		WebUI.sendKeys(findTestObject('Login Page/input_Password'), password)
		WebUI.click(findTestObject('Login Page/button_Login'))
		WebUI.waitForElementPresent(findTestObject('Admin Menu/User Management/h5_System Users'), GlobalVariable.DELAY_TIME)
	}

	@Keyword
	def static void loginGlobalVariable() {
		login(GlobalVariable.BASE_URL, GlobalVariable.G_USERNAME, GlobalVariable.PASSWORD)
	}

	@Keyword
	def static void logout() {
		WebUI.click(findTestObject('Login Page/span_Dropdown Account'))
		WebUI.delay(1)
		WebUI.click(findTestObject('Login Page/a_Logout'))

		WebUI.verifyElementPresent(findTestObject('Login Page/h5_Login'), GlobalVariable.DELAY_TIME)
	}
}
