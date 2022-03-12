package uz.ilkhomkhuja.mvpexampleproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import uz.ilkhomkhuja.mvpexampleproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), Contact.View {

    lateinit var binding: ActivityMainBinding
    var presenter: Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        presenter = Presenter(this, Model())
        binding.button.setOnClickListener { presenter?.onButtonClick() }
    }

    override fun showProgress() {
       binding.progressBar.visibility = View.VISIBLE
       binding.textView.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        binding.progressBar.visibility = View.GONE
        binding.textView.visibility = View.INVISIBLE
    }

    override fun setString(string: String?) {
        binding.textView.text = string
    }
}