/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ctrl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author san
 */
class waktu {
    
    public String getTanggal() {  
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");  
        Date date = new Date();  
        
                String strDate = dateFormat.format(date);  
                
                
        return strDate;  
    }  
}
