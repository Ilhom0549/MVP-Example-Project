package uz.ilkhomkhuja.mvpexampleproject

class Presenter(
    private var mainView: Contact.View?,
    private val model: Contact.Model
) : Contact.Presenter,
    Contact.Model.OnFinishedListener {

    override fun onButtonClick() {
        if (mainView != null) {
            mainView?.showProgress()
        }
        model.getNextCourse(this)
    }

    override fun onDestroy() {
        mainView = null
    }

    override fun onFinished(string: String?) {
        if (mainView != null) {
            mainView?.setString(string)
            mainView?.hideProgress()
        }
    }
}