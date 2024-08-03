package com.ozgurbaykal.paymentsdk

interface PaymentCallback {
    fun onSuccess()
    fun onFailure(error: String)
}

object PaymentSDK {

    private const val VALID_OTP = "123456" //EXAMPLE

    fun startPayment(cardNo: String, expDate: String, cvv: String, amount: Double, callback: PaymentCallback) {
        Thread {
            try {
                //Thread.sleep(2000) // Simulated network delay
                callback.onSuccess()
            } catch (e: InterruptedException) {
                callback.onFailure("Payment initiation failed")
            }
        }.start()
    }

    fun confirmPayment(otp: String, callback: PaymentCallback) {
        Thread {
            try {
                //Thread.sleep(1000) // Simulated network delay
                if (otp == VALID_OTP) {
                    callback.onSuccess()
                } else {
                    callback.onFailure("Invalid OTP")
                }
            } catch (e: InterruptedException) {
                callback.onFailure("OTP confirmation failed")
            }
        }.start()
    }
}