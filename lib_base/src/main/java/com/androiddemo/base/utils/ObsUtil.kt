package com.androiddemo.base.utils

import android.util.Log
import com.obs.services.ObsClient
import com.obs.services.exception.ObsException
import com.obs.services.model.AccessControlList
import com.obs.services.model.HeaderResponse
import com.obs.services.model.ObsBucket
import com.obs.services.model.StorageClassEnum
import java.io.File


/****
 * @author : zhangjing
 * @date : 星期二 11/14/23
 */
object ObsUtil {

    private const val AK = "RUREQX5QTVQQDB3FTSUC"
    private const val SK = "o93blUjtg0qS5jn4VOnwTwlyKpYH0bFBVWeZEhPm"
    private const val END_POINT = "obs.ru-moscow-1.hc.sbercloud.ru"

    private val obsClient by lazy {
        ObsClient(AK, SK, END_POINT)
    }

    fun listObjectsTEST() {
        ThreadUtils.runOnChildThread {
            val result = obsClient.listObjects("weplay-test-bucket")
            for (obsObject in result.objects) {
                Log.i("listObjectsTEST", "\t" + obsObject.objectKey)
                Log.i("listObjectsTEST", "\t" + obsObject.owner)
            }
        }
    }

    fun uploadFileTest(file: File) {
        ThreadUtils.runOnChildThread {
            Log.d("uploadFileTest", "start uploadFileTest")
            try {
                val result = obsClient.putObject("weplay-test-bucket", "test_upload_pic.webp", file)
                Log.d("uploadFileTest", "putSuccess, $result")
                Log.d("uploadFileTest", "putSuccess, url ${result.objectUrl}")
            } catch (e: ObsException) {
                Log.e("uploadFileTest", e.toString())
            } catch (t: Throwable) {
                Log.e("uploadFileTest", t.toString())
            }
        }
    }

    fun createBucketTest() {
        val obsBucket = ObsBucket()
        obsBucket.bucketName = "weplay-test-bucket"
        // 设置桶访问权限为公共读，默认是私有读写
        obsBucket.acl = AccessControlList.REST_CANNED_PUBLIC_READ
        // 设置桶的存储类型为归档存储
        obsBucket.bucketStorageClass = StorageClassEnum.COLD
        // 设置桶区域位置
        obsBucket.location = "ru-moscow-1"
        Log.i("CreateBucket", "start create bucket")
        // 创建桶
        try {
            // 创建桶成功
            val response: HeaderResponse = obsClient.createBucket(obsBucket)
            Log.i("CreateBucket", response.requestId)
        } catch (e: ObsException) {
            // 创建桶失败
            Log.e("CreateBucket", "Response Code: " + e.responseCode)
            Log.e("CreateBucket", "Error Message: " + e.errorMessage)
            Log.e("CreateBucket", "Error Code:       " + e.errorCode)
            Log.e("CreateBucket", "Request ID:      " + e.errorRequestId)
            Log.e("CreateBucket", "Host ID:           " + e.errorHostId)
            Log.e("CreateBucket", e.toString())
        } catch (t: Throwable) {
            Log.e("CreateBucket", t.toString())
        }
    }


    fun upload() {

    }

    fun onDestroy() {
        obsClient.close()
    }
}