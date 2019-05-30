package com.checkingAccount;

class EndingThread extends Thread{
	
	@Override
	public void run() {
		
		String ending[] = {"***************************************************************************************************",
				           "                                              제작사",
				           "",
				           "                                          Sunkist 가계부",
				           "                           일상에서 시작하는 제테크, 가계부 작성의 모든것",
				           "",
				           "                                          제공 아이티윌",
				           "",
				           "                                           배급 황태용",
				           "",
				           "                                           감독 정지훈",
				           "",
				           "                                           기획 정지훈",
				           "",
				           "                                           구성 정지훈",
				           "",
				           "                                        장소협찬 아이티윌",
				           "",
				           "                                        제작비지원 정지훈",
				           "",
				           "                                          주연1 정지훈 ",
				           "",
				           "                                          주연2 이정희",
				           "",
				           "                                          주연3 오예린",
				           "",
				           "",
				           "",
				           "",
				           "                                              협찬",
				           "",
				           "",
				           "",
                           "        			                        .OO",
                           "        			                      .OOOO",
                           "        			                     .OOOO'",
                           "        			                     OOOO'          .-~~~~-.",
                           "        			                     OOO'          /   (o)(o)",
                           "        			             .OOOOOO `O .OOOOOOO. /      .. |",
                           "        			         .OOOOOOOOOOOO OOOOOOOOOO/\\    \\____/",
                           "        			       .OOOOOOOOOOOOOOOOOOOOOOOO/ \\\\   ,\\_/",
                           "        			      .OOOOOOO%%OOOOOOOOOOOOO(#/\\     /.",
                           "        			     .OOOOOO%%%OOOOOOOOOOOOOOO\\ \\\\  \\/OO.",
                           "        			    .OOOOO%%%%OOOOOOOOOOOOOOOOO\\   \\/OOOO.",
                           "        			    OOOOO%%%%OOOOOOOOOOOOOOOOOOO\\_\\/\\OOOOO",
                           "        			    OOOOO%%%OOOOOOOOOOOOOOOOOOOOO\\###)OOOO",
                           "        			    OOOOOO%%OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
                           "        			    OOOOOOO%OOOOOOOOOOOOOOOOOOOOOOOOOOOOOO",
                           "        			    `OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO'",
                           "        			  .-~~\\OOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO'",
                           "        			 / _/  `\\(#\\OOOOOOOOOOOOOOOOOOOOOOOOOOOO'",
                           "        			/ / \\  / `~~\\OOOOOOOOOOOOOOOOOOOOOOOOOO'",
                           "        		    |/'  `\\//  \\\\ \\OOOOOOOOOOOOOOOOOOOOOOOO'",
                           "        			       `-.__\\_,\\OOOOOOOOOOOOOOOOOOOOO'",
                           "        			          `OO\\#)OOOOOOOOOOOOOOOOOOO'",
                           "        			           `OOOOOOOOO''OOOOOOOOO'",
                           "        			            `\"\"\"\"\"\"'  `\"\"\"\"\"\"'",
                           "",
                           "                        WeeeeeeeD ",                                                            
                           "                     Eeeeeu  Xeeeeeey",                                                         
                           "                   eeeK   5GEGE999EeeeX",                                                       
                           "                  eey  eeeeeeeE999999eee         eeeeeeeeeeez      WyyW",                       
                           "                 ee  eeeuXeeu5e9999999Eee        9GD#GGeeeeeX   eeeeeeeeeeK",                   
                           "                ee  eee   #e  e99999999Eee           9GDEG    yeE9eGKKGeeeeD",                  
                           "                ee ee9eeDGee  eEeeeeeeeeee           9GDEG    e9DGz        u",                  
                           "               Eez eE9EGeeEe  ee      u ee,          9GDEG   uezDe   e9zX5DG",                  
                           "               9ez eE999999e  eeyy555Xe ee,          9GDEG   yeDDe   eeeeEGe",                  
                           "                ee ee999999e ueeeeeeeeG ee           9GD9D    e#DGz     9D#e",                  
                           "                ee  ee99999e  D E99Eee zee       9GD#GGeeeeeX zeE#e#  Xe9z#e",                  
                           "                 ee  eee999eDWK EEeee Kee        eeeeeeeeeeez  ueeeeeeeeeeee ",                 
                           "                  eeX  eeeeeeeeeeee  eee         ,         ,      KXDy     K",                  
                           "                   Geey   K#GEzu   9eeX",                                                       
                           "                     zeeeey    Deeeey",                                                         
                           "                        u9eeeeeez",                                                 
				           "",
				           "                                                      u5zEeeeeeeeeeeeeeeeeeeeeGzW",                
				           "                                             KXEeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeez",          
				           "                                     W#eeeeeeeeeeeGEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEGeeee#",       
				           "                              uzeeeeeeeeeGEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEeee",      
				           "                         XeeeeeeeeGEEEEEEEEEEEEEEGGGEEEEEEEEEEEEEEEEEEEEEEEEEEGGGEEEEEEEEEEEee",      
				           "                   ueeeeeeeeeeeeEGeeeeeeeeeeeGeeeeeeeeGeeeeeeeeeEeeeeeeeeeeEeeeeeeeeEEEEEEEeee",      
				           "                K     #eEe     eEe#    e    9eeX     #eeX     XeGe   ee   eee     ueEEEEEeee#",       
				           "             Xee9  ee,5eGe  G  eGee    e    eee  yeG Dee       eGe    e  Kee9  eeKyeEEEeeee",         
				           "          5eeeeee    Deeee  e  eeeG  e e e  Eeee    zeee,  e   eGe  e XX Weee  e WWeeeee9",           
				           "        GeeeGEEe#eee   eeX  e  5ee#  e   e  #eeXeee   ee   eW  eGe  eK   WeeG  eK  eee",              
				           "      DeeeEEEEEe   ,  ,ee   e   ee,  e   e   ee      yeeX     XeGe  ee    eee  W  y5",                
				           "     eeeEEEEEEEeee9zGeeeeEeeeeeEeeeeeeeeeeeeeeeee#zeeeeeeee9EeeeEeeeeeeeeeeeeeeW",                    
				           "    ,eeEEEEEEEEEGeeeeeGEGeeeGeeeGEeeeeeeeeeeeEEGeeeeeEEEEeeeeeGEEGeeeeeeeeeu",                        
				           "     eeEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEGeeeeeeee9K",                             
				           "     KeeeeEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEEeeeeeeeeeee#K",                                   
				           "       ,eeeeeeeeeGEEEEEEEEEEEEEEEEEEEGGeeeeeeeeeeeeeeeezy",                                           
				           "            yEeeeeeeeeeeeeeeeeeeeeeeeeeeeeee#5u",
				           "",
				           "",
				           "",
				           ""};
		
		for(int i=0;i<ending.length;i++){
			System.out.println(ending[i]);
		
			try {
				sleep(100);
			} catch (Exception e) {
		
			}
		}
		System.out.println();
	}
	
}


public class Ending {

	public static void main(String[] args) {
		
		EndingThread ed = new EndingThread();
		System.out.println("\n\n\n\n");
		
		ed.start();
		
		try {
			ed.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
