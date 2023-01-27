package ValidationScripts;

import org.testng.annotations.Test;

import central.PageObject.CWFCWIDependencyWFT;
import central.PageObject.SCCreateAssetTaskV02;
import central.PageObject.SCMandatoryAttachmentV04;
import central.PageObject.SCMandatoryMDTaskV03;
import central.PageObject.SCNoResourceTaskV01;
import central.TestCases.TC01_SCExtLogin;

public class TCTaskValidationsWFTCreations extends WSTCreation02  //TC01_SCExtLogin //WSTCreation02
{
	@Test(priority=6) //6
	public void NoResourceValidation01() throws Exception
	{
		SCNoResourceTaskV01 valid01 = new SCNoResourceTaskV01(driver);
		valid01.CreateWFTV1_FirstPage();
		valid01.ResourceNotAssigned();//Task Responsibility ==> Acquiring Editor
		valid01.Task2Adding();
		valid01.savewftv1();
	}
	
	@Test(priority=7) //7
	public void AssetTaskValidation02() throws Exception
	{
		SCCreateAssetTaskV02 valid02 = new SCCreateAssetTaskV02(driver);
		valid02.CreateWFTV2_FirstPage();
		valid02.CreateAssetTask();
		valid02.Task2Adding();
		valid02.savewftv2();
	}
	
	@Test(priority=8)
	public void MandatoryMDTaskValidation03() throws Exception
	{
		SCMandatoryMDTaskV03 valid03 = new SCMandatoryMDTaskV03(driver);
		valid03.CreateWFTV3_FirstPage();
		valid03.MandatoryMDTask();
		valid03.Task2Adding();
		valid03.savewftv3();
	}
	
	@Test(priority=9)
	public void MandatoryAttachmentTaskValidation04() throws Exception
	{
		SCMandatoryAttachmentV04 valid04 = new SCMandatoryAttachmentV04(driver);
		valid04.CreateWFTV4_FirstPage();
		valid04.MandatoryAttachmentTask();
		valid04.Task2Adding();
		valid04.savewftv4();
	}	
	@Test(priority=10)
	public void CWFdeptaskCReation() throws Exception 
	{
		
		CWFCWIDependencyWFT obj1 = new CWFCWIDependencyWFT(driver);
		obj1.PredecessorCWFTemplateCreation1();
		obj1.SuccessorCWFTemplateCreation2();
		
		//CWIWF creation
		
		obj1.PredecessorCWIWFTemplateCreation1();
		obj1.SuccessorCWIWFTemplateCreation2();
	}
}
