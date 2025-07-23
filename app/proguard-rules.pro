# Исключения для классов перечислений
-keep class ru.iteco.fmhandroid.enum.FragmentsTags

# Исключения для классов данных
-keep class ru.iteco.fmhandroid.dto.** { *; }

# Ignore missing SSL providers to avoid R8 errors
-dontwarn org.bouncycastle.**
-dontwarn org.conscrypt.**
-dontwarn org.openjsse.**

