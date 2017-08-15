/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.udea.pruebas_ps0.util;

import co.edu.udea.pruebas_ps0.ldl.LDL;
import co.edu.udea.pruebas_ps0.ldl.NodoDoble;
import co.edu.udea.pruebas_ps0.util.estadistica.MedidasEstadisticas;
import co.edu.udea.pruebas_ps0.util.excepcion.ValidacionPS0;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellReference;

/**
 *
 * @author Jhonatan Orozco Blandón
 */
public class ArchivosExcelIO {

    private Sheet sheet;
    private Workbook workbook;
    private final ArrayList<LDL> listaColumnas;

    public ArchivosExcelIO() {
        this.listaColumnas = new ArrayList<>();
    }


    public ArrayList<LDL> getListaColumnas() {
        return listaColumnas;
    }

    public void convertirExcelALDL(String nombreArchivo) throws FileNotFoundException,
            ValidacionPS0, IOException {
        File f = encontrarArchivo(nombreArchivo);
        workbook = abrirLibroExcel(f);
        sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) {
            Row fila = rowIterator.next();
            Iterator<Cell> cellIterator = fila.cellIterator();
            int i = 0;

            while (cellIterator.hasNext()) {
                Cell celda = cellIterator.next();
                if (listaColumnas.size() <= i) {
                    listaColumnas.add(i, new LDL());
                }
                if (esCeldaValida(celda)) {
                    listaColumnas.get(i).insertar(new NodoDoble(celda.getNumericCellValue()));
                }
                i++;
            }
        }
    }

    public boolean esCeldaValida(Cell celda) throws ValidacionPS0 {
        if (celda == null || celda.getCellType() == Cell.CELL_TYPE_BLANK) {
            return false;
        } else if (celda.getCellType() != Cell.CELL_TYPE_NUMERIC) {
            CellReference cr = new CellReference(celda);
            throw new ValidacionPS0("Error leyendo la celda "+cr.formatAsString());
        }
        return true;
    }

    public File encontrarArchivo(String nombreArchivo) throws FileNotFoundException,
            ValidacionPS0 {
        File f = new File(nombreArchivo);
        String extArchivo;
        if (!f.exists()) {
            throw new FileNotFoundException("El archivo no existe");
        }
        extArchivo = FilenameUtils.getExtension(f.getName());
        if ("xls".compareTo(extArchivo) != 0) {
            throw new ValidacionPS0("La extensión es inválida");
        }

        return f;
    }

    public Workbook abrirLibroExcel(File f) throws FileNotFoundException,
            IOException {
        InputStream in = new FileInputStream(f);
        Workbook w = new HSSFWorkbook(in);

        return w;
    }
    
    public void generarResultadosVariable(Sheet s,LDL lista, int numeroFilas) throws 
            URISyntaxException, IOException{
        MedidasEstadisticas medidas=new MedidasEstadisticas();
            int numeroCeldas=0;
            double media;
            double desviacion;
            Row r=s.createRow(numeroFilas);
            numeroFilas++;
            Cell c=r.createCell(numeroCeldas);
            c.setCellValue("Variable "+ (numeroFilas-1));
            numeroCeldas++;
            c=r.createCell(numeroCeldas);
            media=medidas.calcularMedia(lista);
            c.setCellValue(media);
            numeroCeldas++;
            c=r.createCell(numeroCeldas);
            desviacion=medidas.calcularDesviacionEstandar(lista);
            c.setCellValue(desviacion);
    }
    
    public File generarResultados(ArrayList <LDL> variables) throws URISyntaxException, 
            IOException{
        int numeroVariables=variables.size();
        Workbook w = new HSSFWorkbook();
        Sheet s=w.createSheet();
        String rutaProyecto;
        int numeroCeldas=0;
        Row r=s.createRow(0);
        Cell c=r.createCell(numeroCeldas);
        c.setCellValue("Variables");
        numeroCeldas++;
        c=r.createCell(numeroCeldas);
        c.setCellValue("Media");
        numeroCeldas++;
        c=r.createCell(numeroCeldas);
        c.setCellValue("Desviación");
        System.out.println("numero variables"+numeroVariables);
        for (int i = 0; i < numeroVariables; i++) {
            LDL lista=variables.get(i);
            generarResultadosVariable(s,lista,i+1);
        }

         rutaProyecto = ArchivosExcelIO.class.getProtectionDomain().
                    getCodeSource().getLocation().toURI().getPath();
        Date date = new Date();
        
        String nombreArchivo = "resultado " + date.getTime()
                + ".xls";
        rutaProyecto = rutaProyecto.concat(nombreArchivo);
        FileOutputStream outputStream = new FileOutputStream(rutaProyecto);
        w.write(outputStream);
        File f=new File(rutaProyecto);
        return f;
            
    }

}
