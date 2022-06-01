/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package responsi;
import responsi.Main.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;

/**
 *
 * @author HP
 */
public class Controller {
    ModelTransaksi modelTransaksi;
    ViewTransaksi viewTransaksi ;

    public Controller(ViewTransaksi viewTransaksi, ModelTransaksi modelTransaksi) {
    this.modelTransaksi = modelTransaksi;
    this.viewTransaksi = viewTransaksi;
    
    //mengecek data yang ada dari database dan memasukkan ke dalam tabel
    if(modelTransaksi.getBanyakData() != 0){
            String data[][] = modelTransaksi.readData();
            viewTransaksi.tabel.setModel((new JTable(data, viewTransaksi.namaKolom)).getModel());
        } else{
            JOptionPane.showMessageDialog(null, "Data Tidak Ada");
        }
    
    //aksi ketika menekan tombol tambah
    viewTransaksi.btnTambah.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nama = viewTransaksi.nama;
        String id = viewTransaksi.getFid().getText();
        String nama_barang = viewTransaksi.getFnama_barang().getText();
        String nama_kasir = viewTransaksi.getFnama_kasir().getText();
        int quantity = Integer.parseInt(viewTransaksi.getFquantity().getText());
        int harga_barang = Integer.parseInt(viewTransaksi.getFharga_barang().getText());
        int diskon = Integer.parseInt(viewTransaksi.getFdiskon().getText());
        double total = (quantity*harga_barang)-(quantity*harga_barang*(diskon*0.01));
        if (id.equals("")||nama_barang.equals("")||nama_kasir.equals("")||quantity==0||harga_barang==0||diskon==0) {
            JOptionPane.showMessageDialog(viewTransaksi, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelTransaksi.tambahData(id,nama_barang,nama_kasir,quantity,harga_barang,diskon,total);
            viewTransaksi.dispose();
            MVC mvc = new MVC();
            mvc.Transaksi();
        }
        }
    });
    
    //aksi ketika menekan tombol update
    viewTransaksi.btnUpdate.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String nama = viewTransaksi.nama;
        String id = viewTransaksi.getFid().getText();
        String nama_barang = viewTransaksi.getFnama_barang().getText();
        String nama_kasir = viewTransaksi.getFnama_kasir().getText();
        int quantity = Integer.parseInt(viewTransaksi.getFquantity().getText());
        int harga_barang = Integer.parseInt(viewTransaksi.getFharga_barang().getText());
        int diskon = Integer.parseInt(viewTransaksi.getFdiskon().getText());
        double total = (quantity*harga_barang)-(quantity*harga_barang*(diskon*0.01));
        if (id.equals("")||nama_barang.equals("")||nama_kasir.equals("")||quantity==0||harga_barang==0||diskon==0) {
            JOptionPane.showMessageDialog(viewTransaksi, "Isi Kolom Kosong Terlebih Dahulu !");
        }else {
            modelTransaksi.updateData(nama,id,nama_barang,nama_kasir,quantity,harga_barang,diskon,total);
            viewTransaksi.dispose();
            MVC mvc = new MVC();
            mvc.Transaksi();
        }
        }
    });
    
    
    //aksi ketika menekan tombol delete
    viewTransaksi.btnDelete.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) { 
        String id = viewTransaksi.getFid().getText();

        if (id.equals("")) {
            JOptionPane.showMessageDialog(viewTransaksi, "Isi Id yang Akan Dihapus");
        }else {
            modelTransaksi.deleteData(id);
            viewTransaksi.dispose();
            MVC mvc = new MVC();
            mvc.Transaksi();
        }
        }
    });
    
    //aksi ketika menekan tombol clear
     viewTransaksi.btnClear.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                viewTransaksi.fid.setText("");
                viewTransaksi.fnama_barang.setText("");
                viewTransaksi.fnama_kasir.setText("");
                viewTransaksi.fquantity.setText("");
                viewTransaksi.fharga_barang.setText("");
                viewTransaksi.fdiskon.setText("");
                viewTransaksi.ftotal.setText("");
            }
        });
    }
    }