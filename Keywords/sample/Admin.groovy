package sample

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

public class Admin {

	@Keyword
	def static void accessAdminMenu() {
		WebUI.click(findTestObject('Side Menus/a_Admin'))
		WebUI.waitForElementPresent(findTestObject("Admin Menu/User Management/h5_System Users"), GlobalVariable.DELAY_TIME)
	}


	@Keyword
	def static void addNewUser(String employee, String username, String password, String confirmPass, String role, String status) {

		WebUI.click(findTestObject('Admin Menu/User Management/Users/button_Add_User'))
		WebUI.waitForElementPresent(findTestObject('Admin Menu/User Management/Users/Add User/h6_Add User'), GlobalVariable.DELAY_TIME)

		//		set role employee
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/dropdown_Roles'))
		WebUI.waitForElementVisible(findTestObject('Admin Menu/User Management/Users/Add User/div_Select AdminESS'), GlobalVariable.DELAY_TIME)
		if(role.equalsIgnoreCase("Admin")) {
			WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Admin'))
		} else if (role.equalsIgnoreCase("ESS")) {
			WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_ESS'))
		} else {
			throw new RuntimeException("Invalid role: ${role}")
		}


		//		set status employee
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/dropdown_Statuses'))
		WebUI.waitForElementVisible(findTestObject('Admin Menu/User Management/Users/Add User/div_Select EnabledDisabled'), GlobalVariable.DELAY_TIME)
		if(status.equalsIgnoreCase("Enable")) {
			WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Enabled'))
		} else if (status.equalsIgnoreCase("Disable")) {
			WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Disable'))
		} else {
			throw new RuntimeException("Invalid role: ${status}")
		}
		//		set employee name
		WebUI.setText(findTestObject('Admin Menu/User Management/Users/Add User/input_Employee_Name'), employee)
		//		find test object employee
		TestObject employeeName = findTestObject('Admin Menu/User Management/Users/Add User/div_Odis Adalwin', ['employee':employee])
		WebUI.waitForElementVisible(employeeName, 5)

		WebUI.click(employeeName)

		WebUI.sendKeys(findTestObject('Admin Menu/User Management/Users/Add User/input_Username'), username)
		WebUI.sendKeys(findTestObject('Admin Menu/User Management/Users/Add User/input_Password'), password)
		WebUI.sendKeys(findTestObject('Admin Menu/User Management/Users/Add User/input_Confirm Password'), confirmPass)
		
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/button_Save'))
		
		WebUI.verifyElementVisible(findTestObject('Admin Menu/User Management/Users/Add User/popup_SuccessSuccessfully Saved'))
	}
}
