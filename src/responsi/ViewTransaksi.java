/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package responsi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ViewTransaksi extends JFrame{
    //DEKLARASI KOMPONEN
    String nama;
    JTable tabel;
    DefaultTableModel tableModel; //otomatis dibuat kalo buat JTable
    JScrollPane scrollPane;
    Object namaKolom[] = {"ID TRANSAKSI","NAMA BARANG","NAMA KASIR","QUANTITY","HARGA SATUAN","DISKON","TOTAL"}; //membuat kolom dgn array tipe object;
    final JTextField fid = new JTextField(50);
    final JTextField fnama_barang = new JTextField(20);
    final JTextField fnama_kasir = new JTextField(20);
    final JTextField fquantity = new JTextField(10);
    final JTextField fharga_barang = new JTextField(10);
    final JTextField fdiskon = new JTextField(10);
    final JTextField ftotal = new JTextField(10);
    JLabel lid= new JLabel("Id");
    JLabel lnama_barang = new JLabel("Nama Barang");
    JLabel lnama_kasir = new JLabel("Nama Kasir");
    JLabel lquantity = new JLabel("Quantity");
    JLabel lharga_barang = new JLabel("Harga Satuan");
    JLabel ldiskon = new JLabel("Diskon");
    JButton btnTambah = new JButton("Tambah");
    JButton btnUpdate = new JButton("Update");
    JButton btnDelete = new JButton("Delete");
    JButton btnClear = new JButton("Clear");

    public ViewTransaksi(){
        tableModel = new DefaultTableModel(namaKolom,0);
        tabel = new JTable(tableModel);
        scrollPane = new JScrollPane(tabel);
        setLayout(null);
        setSize(1100,600);
        setVisible(true);
        setResizable(false);
        setTitle("Transaksi");
        setDefaultCloseOperation(3);
  
        add(scrollPane);
        add(lid);
        add(fid);
        add(lnama_barang);
        add(fnama_barang);
        add(lnama_kasir);
        add(fnama_kasir);
        add(lquantity);
        add(fquantity);
        add(lharga_barang);
        add(fharga_barang);
        add(ldiskon);
        add(fdiskon);
        add(btnTambah);
        add(btnUpdate);
        add(btnDelete);
        add(btnClear);

        scrollPane.setBounds(20, 35, 700, 345);
        
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        
        lid.setBounds(750, 35, 120, 20);
        fid.setBounds(750, 60, 170, 20);
        lnama_barang.setBounds(750, 90, 120, 20);
        fnama_barang.setBounds(750, 115, 170, 20);
        lnama_kasir.setBounds(750, 145, 120, 20);
        fnama_kasir.setBounds(750, 170, 170, 20);
        lquantity.setBounds(750, 200, 120, 20);
        fquantity.setBounds(750, 225, 170, 20);
        lharga_barang.setBounds(750, 255, 120, 20);
        fharga_barang.setBounds(750, 280, 170, 20);
        ldiskon.setBounds(750, 310, 120, 20);
        fdiskon.setBounds(750, 335, 170, 20);
        btnTambah.setBounds(750, 400, 80, 20);
        btnUpdate.setBounds(750, 430, 80, 20);
        btnDelete.setBounds(850, 400, 80, 20);
        btnClear.setBounds(850, 430, 80, 20);
        
        //mengambil data dari tabel yang di klik
        tabel.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
                JTable target = (JTable)me.getSource();
                int baris = target.getSelectedRow(); // select a row
                nama =tabel.getValueAt(baris, 0).toString();
                fid.setText(tabel.getValueAt(baris, 0).toString());
                fnama_barang.setText(tabel.getValueAt(baris, 1).toString());
                fnama_kasir.setText( tabel.getValueAt(baris, 2).toString());
                fquantity.setText(tabel.getValueAt(baris, 3).toString());
                fharga_barang.setText(tabel.getValueAt(baris, 4).toString()); 
                fdiskon.setText(tabel.getValueAt(baris, 5).toString()); 
                ftotal.setText(tabel.getValueAt(baris, 6).toString()); 
            }
        });
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	setLocationRelativeTo(null);
    }
    
    public JTextField getFid() {
        return fid;
    }

    public JTextField getFnama_barang() {
        return fnama_barang;
    }

    public JTextField getFnama_kasir() {
        return fnama_kasir;
    }
    
    public JTextField getFquantity() {
        return fquantity;
    }
    
    public JTextField getFharga_barang() {
        return fharga_barang;
    }
    
    public JTextField getFdiskon() {
        return fdiskon;
    }
    
    public JTextField getFtotal() {
        return ftotal;
    }
}
