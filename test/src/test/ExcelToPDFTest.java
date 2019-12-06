package test;

import jxl.*;
import jxl.Cell;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.BaseFont;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;


public class ExcelToPDFTest {
	
	public static void main(String[] args) throws DocumentException, IOException {
		Document document = new Document(PageSize.A4,0,0,50,0);  
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("E:\\Desktop\\Daniel\\PdfTable2.pdf"));  
          
        //��������    
        /*  
         * ����itext��֧�����ģ�������Ҫ������������ã���������itext����windowsϵͳ���������壬  
         * �ҵ��ļ��󣬴����ԣ����ļ���������·����Ϊ���������ɡ�  
         */    
        //����BaseFont����ָ�����壬���뷽ʽ,�Ƿ�Ƕ��    
        BaseFont bf=BaseFont.createFont("C:\\Windows\\Fonts\\simkai.ttf", BaseFont.IDENTITY_H, false);    
        //����Font���󣬽�����������������С��������    
        Font font=new Font(bf,13,Font.NORMAL);    
        int rowNum = 0;  
        int colNum = 0;  
        try {  
            Workbook workbook=Workbook.getWorkbook(new File("E:\\Desktop\\Daniel\\�ⵥλ�����Ѵ�����2019��06��27��03ʱ52��.xls"));  
              
            Sheet sheet=workbook.getSheet(0);  
            int column=sheet.getColumns();  
              
            //�������ҳ�����еĿ��кͿ���  
            List<Integer> nullCol = new ArrayList<Integer>();  
            List<Integer> nullRow = new ArrayList<Integer>();  
            for(int j=0;j<sheet.getColumns();j++){  
                int nullColNum = 0;  
                for(int i=0;i<sheet.getRows();i++){  
                    Cell cell=sheet.getCell(j, i);  
                    String str = cell.getContents();  
                    if(str == null || "".equals(str)){  
                        nullColNum ++ ;  
                    }  
                }  
                if(nullColNum == sheet.getRows()){  
                    nullCol.add(j);  
                    column--;  
                }  
            }  
              
            for(int i=0;i<sheet.getRows();i++){  
                int nullRowNum = 0;  
                for(int j=0;j<sheet.getColumns();j++){  
                    Cell cell=sheet.getCell(j, i);  
                    String str = cell.getContents();  
                    if(str == null || "".equals(str)){  
                        nullRowNum ++ ;  
                    }  
                }  
                if(nullRowNum == sheet.getColumns()){  
                    nullRow.add(i);  
                }  
            }  
            PdfPTable table=new PdfPTable(column);    
            Range[] ranges = sheet.getMergedCells();  
              
            PdfPCell cell1=new PdfPCell();  
            for(int i=0;i<sheet.getRows();i++){  
                if(nullRow.contains(i)){    //�����һ���ǿ��У���������һ��  
                    continue;  
                }  
                for(int j=0;j<sheet.getColumns();j++){  
                    if(nullCol.contains(j)){    //�����һ���ǿ��У���������һ��  
                        continue;  
                    }  
                    boolean flag = true;  
                    Cell cell=sheet.getCell(j, i);  
                    String str = cell.getContents();  
                    for(Range range : ranges){    //�ϲ��ĵ�Ԫ���жϺʹ���  
                        if(j >= range.getTopLeft().getColumn() && j <= range.getBottomRight().getColumn()   
                                && i >= range.getTopLeft().getRow() && i <= range.getBottomRight().getRow()){  
                            if(str == null || "".equals(str)){  
                                flag = false;  
                                break;  
                            }  
                            rowNum = range.getBottomRight().getRow() - range.getTopLeft().getRow()+1;  
                            colNum = range.getBottomRight().getColumn() - range.getTopLeft().getColumn()+1;  
                            if(rowNum > colNum){  
                                cell1 = mergeRow(str, font, rowNum);  
                                cell1.setColspan(colNum);  
                                table.addCell(cell1);  
                            }else {  
                                cell1 = mergeCol(str, font, colNum);  
                                table.addCell(cell1);  
                            }  
                            //System.out.println(num1 + "  " + num2);  
                            flag = false;  
                            break;  
                        }  
                    }  
                    if(flag){  
                        table.addCell(getPDFCell(str,font));           
                    }  
                }  
            }  
              
            workbook.close();  
            document.open();        
            document.add(table);    
            document.close();    
            writer.close();  
        } catch (Exception e) {  
            // TODO Auto-generated catch block  
            e.printStackTrace();  
        }  
	}
	
    //�ϲ��еľ�̬����    
    public static PdfPCell mergeRow(String str,Font font,int i) {    
            
        //������Ԫ����󣬽����ݼ����崫��    
        PdfPCell cell=new PdfPCell(new Paragraph(str,font));    
        //���õ�Ԫ�����ݾ���    
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);    
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);    
        //���õ�Ԫ�������а����õ�Ԫ�����ڵ�i�е�Ԫ��ϲ�Ϊһ����Ԫ��    
            
        return cell;    
    }    
    
    //�ϲ��еľ�̬����    
    public static PdfPCell mergeCol(String str,Font font,int i) {    
            
        PdfPCell cell=new PdfPCell(new Paragraph(str,font));    
        cell.setMinimumHeight(25);    
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);    
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);    
        //���õ�Ԫ�������а����õ�Ԫ�����ڵ�i�е�Ԫ��ϲ�Ϊһ����Ԫ��    
        cell.setColspan(i);    
            
        return cell;    
    }    
      
     //��ȡָ������������ĵ�Ԫ��    
    public static PdfPCell getPDFCell(String string, Font font)     
    {    
        //������Ԫ����󣬽���������������������Ϊ��Ԫ������    
        PdfPCell cell=new PdfPCell(new Paragraph(string,font));    
            
        cell.setHorizontalAlignment(Element.ALIGN_CENTER);    
        cell.setVerticalAlignment(Element.ALIGN_MIDDLE);    
            
        //������С��Ԫ��߶�    
        cell.setMinimumHeight(25);    
        return cell;    
    }    

}
