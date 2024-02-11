package sample

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.Keys
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
		WebUI.verifyElementVisible(findTestObject('Admin Menu/User Management/Users/Add User/popup_Success'))
	}

	@Keyword
	def static void searchUserWithSpecificData(String type, String value) {
		//		input user name
		WebUI.delay(3)
		
		def cases = type
		switch (cases) {
			case "Username":
				WebUI.sendKeys(findTestObject('Admin Menu/User Management/Users/input_Search Username'), value)
				break
			case "Employee":
				WebUI.sendKeys(findTestObject('Admin Menu/User Management/Users/Search/input_Employee'), value)
				break
			case "Role":
				WebUI.click(findTestObject('Admin Menu/User Management/Users/Search/div_role'))
				WebUI.click(findTestObject('Admin Menu/User Management/Users/Search/div_Roles', [('role'):value]))
				break
			case "Status":
				WebUI.click(findTestObject('Admin Menu/User Management/Users/Search/div_status'))
				WebUI.click(findTestObject('Admin Menu/User Management/Users/Search/div_Statuses', [('status'):value]))
				break
			default:
				false
		}
		

		WebUI.click(findTestObject('Admin Menu/User Management/Users/button_Search'))

		//		verify user succeed search
		WebUI.delay(5)
		WebUI.waitForElementPresent(findTestObject('Admin Menu/User Management/Users/div_Username Record Found',[('result'):value]), GlobalVariable.DELAY_TIME)
	}


	def static void clickSaveAndVerifySuccess() {
		WebUI.click(findTestObject('Admin Menu/User Management/Users/Edit User/button_Save'))
		WebUI.verifyElementVisible(findTestObject('Admin Menu/User Management/Users/Edit User/div_Success'))
	}
	@Keyword
	def static void editUser(String role,String status,String employee,String username, String password=null) {
		//		access edit user page
		WebUI.click(findTestObject('Admin Menu/User Management/Users/i_Edit User'))

		WebUI.waitForElementPresent(findTestObject('Admin Menu/User Management/Users/Edit User/h6_Edit User'), GlobalVariable.DELAY_TIME)

		//		find role before
		String roleBefore = WebUI.getText(findTestObject('Admin Menu/User Management/Users/Edit User/div_Dropdown Role'))
		if (!role.equalsIgnoreCase(roleBefore)) {
			WebUI.click(findTestObject('Admin Menu/User Management/Users/Edit User/div_Dropdown Role'))
			WebUI.delay(1)
			WebUI.click(findTestObject('Admin Menu/User Management/Users/Edit User/div_Result Role', [('role'):role]))
		}

		//		find status before
		String statusBefore = WebUI.getText(findTestObject('Admin Menu/User Management/Users/Edit User/div_Dropdown Status'))
		if (!status.equalsIgnoreCase(statusBefore)) {
			WebUI.click(findTestObject('Admin Menu/User Management/Users/Edit User/div_Dropdown Status'))
			WebUI.delay(1)
			WebUI.click(findTestObject('Admin Menu/User Management/Users/Edit User/div_Result Status', [('status'):status]))
		}

		//		find employee before
		TestObject objEmployee = findTestObject('Admin Menu/User Management/Users/Edit User/input_Employee')
		String employeeBefore = WebUI.getAttribute(objEmployee, 'value')
		if (!employee.equalsIgnoreCase(employeeBefore)) {

			for (int i = 0; i < employeeBefore.length(); i++) {
				WebUI.sendKeys(objEmployee, '\ue003')
			}
			WebUI.delay(1)
			WebUI.setText(findTestObject('Admin Menu/User Management/Users/Edit User/input_Employee'), employee)
			WebUI.delay(GlobalVariable.DELAY_TIME)

			WebUI.click(findTestObject('Admin Menu/User Management/Users/Edit User/div_Result Employee', [('employee'): employee]))
		}



		//		find user name before
		TestObject objUsername = findTestObject('Admin Menu/User Management/Users/Edit User/input_Username')
		String usernameBefore = WebUI.getAttribute(objUsername, 'value')
		if (!username.equalsIgnoreCase(usernameBefore)) {

			for (int i = 0; i < usernameBefore.length(); i++) {
				WebUI.sendKeys(objUsername, '\ue003')
			}
			WebUI.delay(1)
			WebUI.setText(findTestObject('Admin Menu/User Management/Users/Edit User/input_Username'), username)
		}

		//check if user want change password
		if(password != null) {
			WebUI.click(findTestObject('Admin Menu/User Management/Users/Edit User/label_Yes Update Password'))
			WebUI.waitForElementPresent(findTestObject('Admin Menu/User Management/Users/Edit User/div_Box Change Password'), GlobalVariable.DELAY_TIME)

			//		set password and confirm password
			WebUI.setText(findTestObject('Admin Menu/User Management/Users/Edit User/input_Password'), password)
			WebUI.setText(findTestObject('Admin Menu/User Management/Users/Edit User/input_Confirm Password'), password)
		}

		//		click save and verify success
		clickSaveAndVerifySuccess()
	}

	@Keyword
	def static void deleteUser(String username) {
		searchUserByUsername(username)

		WebUI.waitForElementPresent(findTestObject('Admin Menu/User Management/Users/i_Delete User'), GlobalVariable.DELAY_TIME)
		WebUI.click(findTestObject('Admin Menu/User Management/Users/i_Delete User'))

		WebUI.waitForElementPresent(findTestObject('Admin Menu/User Management/Users/div_Are You Sure Delete'), GlobalVariable.DELAY_TIME)
		WebUI.click(findTestObject('Admin Menu/User Management/Users/button_Yes, Delete'))

		WebUI.verifyElementPresent(findTestObject('Admin Menu/User Management/Users/div_Success Deleted'), GlobalVariable.DELAY_TIME)
	}
}
