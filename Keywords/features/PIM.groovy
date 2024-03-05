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

public class PIM {

	@Keyword
	def static void accessPIMMenu() {
		WebUI.click(findTestObject('Side Menus/a_PIM'))
		WebUI.waitForElementPresent(findTestObject('PIM Menu/PIM/h5_Employee Information'), 0)
	}

	@Keyword
	def static void addNewEmployee(String photo, String firstname, String middlename, String lastname, String employeeid) {
		WebUI.click(findTestObject('PIM Menu/PIM/button_Add'))
		WebUI.verifyElementPresent(findTestObject('PIM Menu/PIM/Add Employee/h6_Add Employee'), GlobalVariable.Delay_Time)

		WebUI.uploadFile(findTestObject('PIM Menu/PIM/Add Employee/input_Add Picture'), photo)
		WebUI.delay(GlobalVariable.Delay_Time)
		WebUI.setText(findTestObject('PIM Menu/PIM/Add Employee/input_Firstname'), firstname)
		WebUI.setText(findTestObject('PIM Menu/PIM/Add Employee/input_Middlename'), middlename)
		WebUI.setText(findTestObject('PIM Menu/PIM/Add Employee/input_Lastname'), lastname)

		//		check id employee
		TestObject objId = findTestObject('PIM Menu/PIM/Add Employee/input_Employee Id')
		String idBefore = WebUI.getAttribute(objId, 'value')
		if (!employeeid.equalsIgnoreCase(idBefore)) {

			for (int i = 0; i < idBefore.length(); i++) {
				WebUI.sendKeys(objId, '\ue003')
			}
			WebUI.delay(1)
			WebUI.setText(findTestObject('PIM Menu/PIM/Add Employee/input_Employee Id'), employeeid)
		}

		WebUI.click(findTestObject('PIM Menu/PIM/Add Employee/button_Save'))

		WebUI.waitForElementPresent(findTestObject('PIM Menu/PIM/Add Employee/div_Success'), GlobalVariable.Delay_Time)
		accessPIMMenu()
	}

	@Keyword
	def static void searchEmployee(String name) {
		WebUI.setText(findTestObject('PIM Menu/PIM/input_Employee Name'), name)
		WebUI.click(findTestObject('PIM Menu/PIM/button_Search'))
		WebUI.delay(3)
		WebUI.scrollToElement(findTestObject('PIM Menu/PIM/Search Employee/div_First Middle Name'), 0)
		WebUI.waitForElementPresent(findTestObject('PIM Menu/PIM/Search Employee/div_First Middle Name'), GlobalVariable.Delay_Time)
		String fmName = WebUI.getText(findTestObject('PIM Menu/PIM/Search Employee/div_First Middle Name'))
		String lastName = WebUI.getText(findTestObject('PIM Menu/PIM/Search Employee/div_Last Name'))

		String fullName = fmName+" "+lastName

		WebUI.verifyMatch(name, fullName, false)
	}

	@Keyword
	def static void updatePersonalDetailEmployee(String employee ) {
		searchEmployee(employee)

		WebUI.delay(3)
		WebUI.click(findTestObject('PIM Menu/PIM/Search Employee/i_Edit'))
		WebUI.waitForElementPresent(findTestObject('PIM Menu/PIM/Edit Employee/h6_Personal Detail'), 3)
	}

	@Keyword
	def static void deleteEmployee(String name) {
		searchEmployee(name)
		WebUI.click(findTestObject('PIM Menu/PIM/Search Employee/i_Delete'))
		WebUI.waitForElementPresent(findTestObject('PIM Menu/PIM/div_Are you Sure Delete'), 0)
		WebUI.click(findTestObject('PIM Menu/PIM/button_Yes, Delete'))
		WebUI.verifyElementVisible(findTestObject('PIM Menu/PIM/div_Success Deleted'))
	}
}
