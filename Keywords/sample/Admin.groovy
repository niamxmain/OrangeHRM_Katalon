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
	def static void addNewUser(String employee, String username, String password, String role, String status) {

		WebUI.click(findTestObject('Admin Menu/User Management/Users/button_Add_User'))
		WebUI.waitForElementPresent(findTestObject('Admin Menu/User Management/Users/Add User/h6_Add User'), GlobalVariable.DELAY_TIME)

		//		set role employee
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Dropdown Role'))
		WebUI.waitForElementVisible(findTestObject('Admin Menu/User Management/Users/Add User/div_Result Role'), GlobalVariable.DELAY_TIME)
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Type Role', [('role'):role]))


		//		set status employee
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Dropdown Status'))
		WebUI.waitForElementVisible(findTestObject('Admin Menu/User Management/Users/Add User/div_Result Status'), GlobalVariable.DELAY_TIME)
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Type Status', [('status'):status]))

		//		set employee name
		WebUI.setText(findTestObject('Admin Menu/User Management/Users/Add User/input_Employee_Name'), employee)
		//		find test object employee
		WebUI.delay(5)
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/div_Employee Name', [('employee'):employee]), FailureHandling.STOP_ON_FAILURE)

		WebUI.sendKeys(findTestObject('Admin Menu/User Management/Users/Add User/input_Username'), username)
		WebUI.sendKeys(findTestObject('Admin Menu/User Management/Users/Add User/input_Password'), password)
		WebUI.sendKeys(findTestObject('Admin Menu/User Management/Users/Add User/input_Confirm Password'), password)
		
//		saved data
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Add User/button_Save'))
//verify data successfully saved
		WebUI.verifyElementVisible(findTestObject('Admin Menu/User Management/Users/Add User/popup_SuccessSuccessfully Saved'))
	}
	
	@Keyword
	def static searchUserByUsername(String username) {
//		input username
		WebUI.click(findTestObject('Admin Menu/User Management/Users/input_Search Username'))
		WebUI.sendKeys(findTestObject('Admin Menu/User Management/Users/input_Search Username'), username)
		
		WebUI.click(findTestObject('Admin Menu/User Management/Users/button_Search'))
		
//		verify user succeed search
		WebUI.delay(5)
		WebUI.verifyElementVisible(findTestObject('Admin Menu/User Management/Users/div_Username Recorded',[('username'):username]))
	}
	
//	@Keyword
//	def static ensureUserSearchSucceed() {
//		
//	}
}
