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
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

WS.comment('Phone number less than 8 digits')

def organization_name = 'Organization 1'
def full_name = 'Halim Cakra'
def phone = '08991080'
def email = 'halim_testingAPI@yahoo.com'
def organizationname = 'organization name'
def fullname = 'full name'
def phone_number = 'phone'
def email_address = 'email'

'Send Request'
responseBody = WS.sendRequest(findTestObject('API/MileApp', [('organizationname') : organizationname, ('fullname') : fullname, 
			('phone_number') : phone_number, ('email_address') : email_address,
			('organization_name') : organization_name, ('full_name') : full_name
            , ('email') : email, ('phone') : phone]))

WS.verifyResponseStatusCode(responseBody, 400)
WS.verifyElementPropertyValue(responseBody, 'status', false)
WS.verifyElementPropertyValue(responseBody, 'message', 'Phone number cannot less than 8 digits')

