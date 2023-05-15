package com.example.androidcv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout

data class JobExperience(val company: String, val role: String, val years: Int)

data class Education(val institution: String, val degree: String, val years: Int)

class CV(val name: String, val contact: String) {
    val jobExperiences = mutableListOf<JobExperience>()
    val educations = mutableListOf<Education>()

    fun addJobExperience(company: String, role: String, years: Int) {
        jobExperiences.add(JobExperience(company, role, years))
    }

    fun addEducation(institution: String, degree: String, years: Int) {
        educations.add(Education(institution, degree, years))
    }

    fun printCV(): String {
        var cvString = "Nom: $name\n"
        cvString += "Contact: $contact\n\n"
        cvString += "Expérience professionnelle:\n"
        for (experience in jobExperiences) {
            cvString += "${experience.role} chez ${experience.company}, ${experience.years} ans\n"
        }
        cvString += "\nEducation:\n"
        for (education in educations) {
            cvString += "${education.degree} à ${education.institution}, ${education.years} ans\n"
        }
        return cvString
    }
}

class MainActivity : AppCompatActivity() {
    private var isBannerOne = true

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cv = CV("Guilhem VALENTIN", "guilhem@gmail.com")
        cv.addJobExperience("Cofidis", "Ingénieur", 5)
        cv.addEducation("Université", "Master en Informatique", 2)

        val nameText = findViewById<TextView>(R.id.name_text)
        nameText.text = cv.name

        val informationText = findViewById<TextView>(R.id.information_text)
        informationText.text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore quis nostrud."

        val experienceText = findViewById<TextView>(R.id.experience_text)
        experienceText.text = cv.printCV()

        val changeBannerButton = findViewById<Button>(R.id.change_banner_button)
        val bannerLayout = findViewById<RelativeLayout>(R.id.banner_layout)

        changeBannerButton.setOnClickListener {
            if (isBannerOne) {
                bannerLayout.setBackgroundResource(R.drawable.bannertwo)
                isBannerOne = false
            } else {
                bannerLayout.setBackgroundResource(R.drawable.banner)
                isBannerOne = true
            }
        }
    }
}


