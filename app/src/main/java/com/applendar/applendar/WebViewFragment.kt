package com.applendar.applendar

import android.graphics.Bitmap
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceError
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_web_view.*


class WebViewFragment : Fragment() {


//    private var webView: WebView? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Toast.makeText(context, "Loading", Toast.LENGTH_SHORT).show()
        return inflater.inflate(R.layout.fragment_web_view, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        webView.webViewClient = object : WebViewClient() {
            override fun onReceivedError(
                view: WebView?,
                request: WebResourceRequest?,
                error: WebResourceError?
            ) {
                super.onReceivedError(view, request, error)
                // error, can't connect to the page
                Toast.makeText(context, "Sorry, an error occurred", Toast.LENGTH_SHORT).show()
            }

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                // page loading started
                progressBar.visibility = View.INVISIBLE
            }

            override fun onPageFinished(view: WebView, url: String) {
                // page loading finished
//                progressBar.visibility = View.INVISIBLE
            }
        }
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://dei.uca.edu.sv/moodle/")
    }
}