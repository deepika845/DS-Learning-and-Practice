package InternShipProject;

import javax.crypto.*;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;
public class EncryptDecrypt extends WindowAdapter implements ActionListener
{
    public static JPasswordField PasswordField;
    public static Button EncryptButton, DecryptButton;
    public static Cipher PBECipher;
    public static SecretKey PBEKey;
    public static PBEKeySpec PBEKeySpecification;
    public static PBEParameterSpec PBEParamSpec;
    public static final byte[] Salt = {(byte)0xc7, (byte)0x73, (byte)0x21, (byte)0x8c, (byte)0x7e, (byte)0xc8, (byte)0xee, (byte)0x99};
    public static final int Count = 20;
    public static void main(String[] args)
    {
        try
        {
            Frame frame = new Frame("EncryptDecrypt");
            frame.addWindowListener(new EncryptDecrypt());
            EncryptButton = new Button("Encrypt");
            DecryptButton = new Button("Decrypt");
            PasswordField = new JPasswordField();
            EncryptButton.addActionListener(new EncryptDecrypt());
            DecryptButton.addActionListener(new EncryptDecrypt());
            PasswordField.setBounds(2, 28, 252, 20);
            EncryptButton.setBounds(2, 48, 126, 20);
            DecryptButton.setBounds(128, 48, 126, 20);
            frame.setSize(256, 70);
            frame.add(PasswordField);
            frame.add(EncryptButton);
            frame.add(DecryptButton);
            frame.setResizable(false);
            frame.setLayout(new BorderLayout());
            frame.show();
        }
        catch(Exception e) {}
    }
    public static void InitiateCipher(int mode)
    {
        try
        {
            PBEParamSpec = new PBEParameterSpec(Salt, Count);
            PBEKeySpecification = new PBEKeySpec(PasswordField.getPassword());
            PasswordField.setText("");
            SecretKeyFactory keyFac = SecretKeyFactory.getInstance("PBEWithMD5AndDES");
            PBEKey = keyFac.generateSecret(PBEKeySpecification);
            PBECipher = Cipher.getInstance("PBEWithMD5AndDES");
            EncryptDecrypt.PBECipher.init(mode, EncryptDecrypt.PBEKey, EncryptDecrypt.PBEParamSpec);
        }
        catch(Exception e) {}
    }
    public void Encrypt()
    {
        try
        {
            InitiateCipher(Cipher.ENCRYPT_MODE);
            Frame FileFrame = new Frame();
            FileDialog LoadDialog = new FileDialog(FileFrame, "Load", FileDialog.LOAD);
            LoadDialog.show();
            InputStream In = new BufferedInputStream(new FileInputStream(new File(LoadDialog.getDirectory() + LoadDialog.getFile())));
            FileDialog SaveDialog = new FileDialog(FileFrame, "Save", FileDialog.SAVE);
            SaveDialog.setFile("Encrypted.txt");
            SaveDialog.show();
            CipherOutputStream Out = new CipherOutputStream(new FileOutputStream(new File(SaveDialog.getDirectory() + SaveDialog.getFile())), EncryptDecrypt.PBECipher);
            int i;
            while ((i = In.read()) != -1)
                Out.write(i);
            Out.flush();
            Out.close();
            In.close();
        }
        catch(Exception e) {}
    }
    public void Decrypt()
    {
        try
        {
            InitiateCipher(Cipher.DECRYPT_MODE);
            Frame FileFrame = new Frame();
            FileDialog LoadDialog = new FileDialog(FileFrame, "Load", FileDialog.LOAD);
            LoadDialog.show();
            CipherInputStream In = new CipherInputStream(new FileInputStream(new File(LoadDialog.getDirectory() + LoadDialog.getFile())), EncryptDecrypt.PBECipher);
            FileDialog SaveDialog = new FileDialog(FileFrame, "Save", FileDialog.SAVE);
            SaveDialog.setFile("Decrypted.txt");
            SaveDialog.show();
            OutputStream Out = new BufferedOutputStream(new FileOutputStream(new File(SaveDialog.getDirectory() + SaveDialog.getFile())));
            int i;
            while ((i = In.read()) != -1)
                Out.write(i);
            Out.flush();
            Out.close();
            In.close();
        }
        catch(Exception e) {}
    }
    public void actionPerformed(ActionEvent e)
    {
        try
        {
            if(e.getSource() == EncryptButton)
                Encrypt();
            if(e.getSource() == DecryptButton)
                Decrypt();
        }
        catch(Exception ex) {}
    }
    public void windowClosing(WindowEvent e)
    {
        try
        {
            System.exit(0);
        }
        catch(Exception ex) {}
    }
}