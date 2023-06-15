package pro.megadedh.fooddelivery.uikit.custom.toolbar

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Typeface
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.ColorInt
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.res.ResourcesCompat
import coil.load
import pro.megadedh.fooddelivery.uikit.R
import pro.megadedh.fooddelivery.uikit.databinding.ToolbarBinding

class ActionToolbar @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = R.style.Toolbar,
) : ConstraintLayout(
    context,
    attrs,
    defStyleAttr,
    defStyleRes,
) {

    private val binding: ToolbarBinding

    init {
        binding = ToolbarBinding.inflate(
            /* inflater = */ LayoutInflater.from(context),
            /* parent = */ this,
            /* attachToParent = */ true,
        )

        handleAttributes(context, attrs)
        setBackgroundColor(
            ResourcesCompat.getColor(
                resources,
                R.color.white,
                context.theme,
            ),
        )
    }

    private fun handleAttributes(context: Context, attrs: AttributeSet?) {
        context.obtainStyledAttributes(attrs, R.styleable.ActionToolbar).apply {
            handleBackArrowAttributes()
            handleTitleAttributes()
            handleAccountImageAttributes()
        }.recycle()
    }

    private fun TypedArray.handleBackArrowAttributes() {
        val visibility = getInt(R.styleable.ActionToolbar_visibilityBackIcon, -1)
        if (visibility != -1) {
            setBackIconVisibility(
                when (visibility) {
                    1 -> View.INVISIBLE
                    2 -> View.GONE
                    else -> View.VISIBLE
                },
            )
        }
        val src = getResourceId(R.styleable.ActionToolbar_srcBackIcon, -1)
        if (src != -1) setSrcBackIcon(src)

        val tint = getColor(R.styleable.ActionToolbar_tintBackIcon, -1)
        if (tint != -1) setTintBackIcon(tint)
    }

    private fun TypedArray.handleTitleAttributes() {
        val text = getString(R.styleable.ActionToolbar_toolbarTitleText)
        if (text != null) setBaseTitleText(text)

        val textSize = getDimension(R.styleable.ActionToolbar_toolbarTitleTextSize, -1f)
        if (textSize != -1f) setBaseTitleTextSize(textSize)

        val textStyle = getInt(R.styleable.ActionToolbar_toolbarTitleTextStyle, -1)
        if (text != null) {
            setBaseTitleTextStyle(
                when (textStyle) {
                    1 -> Typeface.BOLD
                    2 -> Typeface.ITALIC
                    else -> Typeface.NORMAL
                },
            )
        }
    }

    private fun TypedArray.handleAccountImageAttributes() {
        val src = getResourceId(R.styleable.ActionToolbar_accountImage, -1)
        if (src != -1) setAccountImageDrawable(src)

        val visibility = getInt(R.styleable.ActionToolbar_visibilityAccountImage, -1)
        if (visibility != -1) {
            setAccountImageVisibility(
                when (visibility) {
                    1 -> View.INVISIBLE
                    2 -> View.GONE
                    else -> View.VISIBLE
                },
            )
        }
    }

    fun setBackIconVisibility(visibility: Int) {
        binding.btnBack.visibility = visibility
    }

    fun setSrcBackIcon(@DrawableRes srcBackIcon: Int) {
        binding.btnBack.setImageResource(srcBackIcon)
    }

    fun setTintBackIcon(@ColorInt tintBackIcon: Int) {
        binding.btnBack.setColorFilter(tintBackIcon)
    }

    fun setAccountImageDrawable(@DrawableRes srcAccount: Int) {
        binding.ivAccount.setImageResource(srcAccount)
    }

    fun setAccountImageFromUrl(url: String) {
        binding.ivAccount.load(url)
    }

    fun setAccountImageVisibility(visibility: Int) {
        binding.ivAccount.visibility = visibility
    }

    fun setBaseTitleText(title: String) {
        binding.tvBaseTitle.text = title
    }

    fun setBaseTitleTextSize(size: Float) {
        binding.tvBaseTitle.textSize = size
    }

    fun setBaseTitleTextStyle(typeface: Int) {
        binding.tvBaseTitle.setTypeface(binding.tvBaseTitle.typeface, typeface)
    }

    fun setCityAndDateTitle(city: String, date: String) {
        binding.tvCityTitle.text = city
        binding.tvDate.text = date
        showCityAndDateMode(true)
    }

    fun showCityAndDateMode(show: Boolean) {
        if (show) {
            setCityAndDateTitleVisibility(View.VISIBLE)
            setBaseTitleVisibility(View.GONE)
        } else {
            setCityAndDateTitleVisibility(View.GONE)
            setBaseTitleVisibility(View.VISIBLE)
        }
    }

    fun setOnBackClickListener(onClick: (View) -> Unit) {
        binding.btnBack.setOnClickListener(onClick)
    }

    private fun setCityAndDateTitleVisibility(visibility: Int) {
        binding.grCityAndDate.visibility = visibility
    }

    private fun setBaseTitleVisibility(visibility: Int) {
        binding.grBaseTitle.visibility = visibility
    }
}
