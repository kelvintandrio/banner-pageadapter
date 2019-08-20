## Banner PageAdapter + Dot Indicator without Adapter
Just using this library and not need adapter.
<br>
This library to make the easy banner with page adapter. Usually, to make this case, you must use an adapter to process data using the PageAdapter method. So, this library uses to set data Banner without using Adapter.

***For library***
```gradle
implementation 'com.github.kelvintandrio:banner-pageadapter:v1.0.0'
```

### Setup Banner
To setup banner, you need ViewPager in XML and give name ID ViewPager. The model XML is like this :

```xml
<LinearLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:orientation="vertical"
        tools:context=".MainActivity">

    <androidx.viewpager.widget.ViewPager
            android:id="@+id/[ID name ViewPager]"
            android:layout_marginTop="16dp"
            android:layout_width="match_parent"
            android:layout_height="210dp"/>

    ....

</LinearLayout>
```
You can modifier layout width and height ViewPager.

To set data Banner, you make source code like this :
```kotlin
[name ID ViewPager].setupPageBanner<[Model]>([name layout item], [context]) {
      setBanner([name objek Model])
      banner {
          /* set data Model to attribute layout in XML
          view.[id item layout] = item?.[data Model]
      }
}
```

```

Copyright 2019 Kelvin Herwanda Tandrio

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
