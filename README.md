# **UniversalAsyncHandler**
## UniversalAsyncHandler to provide http post requests efficiently...

###### This library is very efficient for users who are still using AsyncTasks to post data.

Only you have to add jitpack in your root build.gradle : 	

	allprojects { 	
		repositories  	
		{ 	
			... 	
			maven { url 'https://jitpack.io' } 	
		} 	
	} 	
   
  and add the dependency in app.gradle : <br/>
  
  	dependencies {  
	        compile 'com.github.rohitpuriji:UniversalAsyncHandler:-SNAPSHOT'
		}
  
  This library made with java8 so add the jack option inside defaultCondig in your app gradle file :<br/>
  
        minSdkVersion 16
        targetSdkVersion 25
        versionCode 1
        versionName "1.0"
        jackOptions {
            enabled true
        }
    
  
  and add compile ad dex options :
  
      dexOptions {
        incremental true
    }

    compileOptions {
        sourceCompatibility JavaVersion.VERSION_1_8
        targetCompatibility JavaVersion.VERSION_1_8
    }
    
  now you can simply create a post request by using "HttpPostCaller" class and its method getReponse() this will return object type like this :
   <br/>
   
   	Object object = HttpPostCaller.getResponse(MainActivity.this,"Your post url", Your jsonobject,"Your loading message...");
        if (object instanceof  String){
            AppLogs.printLogs("response :",object.toString());
        }
				
				
# Developed By
   ## Rohit Puri

# License

Copyright  Rohit Puri
Copyright (C) 2011 The Android Open Source Project

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.

        
 
