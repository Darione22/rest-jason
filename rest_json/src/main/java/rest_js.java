
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author informatica
 */
public class rest_js
{
    public static void main(String[] args) 
        {
        post restpost = new post(1, "sanzio", "panzetti", "panzetto.sanzio@hotmail.com", "055334469");
        restpost.post();
        get restget = new get();
        restget.get();
        Delete restdelete = new Delete(1);
        restdelete.Delete();
       
        }
    }