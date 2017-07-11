#include <jni.h>
#include <string>

extern "C"
jobject
Java_kotlindemo_test_com_myapplication_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    std::string bank = "SBI Bank";

    jclass student = env->FindClass( "kotlindemo/test/com/myapplication/model/Bank");
    jmethodID jconstructor = env->GetMethodID( student,  "<init>", "()V" );
    jobject student_obj = env->NewObject( student, jconstructor );

    jmethodID jmethodID1 = env->GetMethodID( student,  "setName", "(Ljava/lang/String;)V" );
//    jstring jstr = env->NewStringUTF( hello.c_str() );
    jstring jstr = env->NewStringUTF( bank.c_str() );
    env->CallVoidMethod( student_obj, jmethodID1, jstr );
    return student_obj;
}
