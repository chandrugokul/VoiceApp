# Voice Changer – Android UI Prototype

இந்த project-ல் தற்போது Android app-க்கான முதல் screen மட்டும் உருவாக்கப்பட்டுள்ளது:
- Login இல்லை
- Female / Original voice option (UI demo)
- Phone number input
- Call / End Call buttons
- Status message

## முக்கிய வரம்பு
இது இன்னும் உண்மையான phone call செய்யாது; voice-ஐ மாற்றியும் அனுப்பாது. Call button அழுத்தும்போது integration இன்னும் சேர்க்கப்படவில்லை என்று தெரிவிக்கும். Android third-party apps சாதாரண SIM call audio-வை நேரடியாக மாற்ற முடியாது. அடுத்த கட்டத்தில் சட்டப்படி அனுமதிக்கப்பட்ட PSTN/VoIP calling provider மற்றும் real-time voice-conversion backend தேவைப்படும். அதற்கு provider account, server, network/audio testing மற்றும் செலவுகள் இருக்கலாம்.

## Android Studio-ல் திறப்பது
1. ZIP-ஐ extract செய்யவும்.
2. Android Studio → Open → `VoiceChangerAndroid` folder தேர்வு செய்யவும்.
3. Gradle sync முடியும் வரை காத்திருக்கவும்.
4. Android SDK Platform 35 மற்றும் JDK 17 நிறுவப்பட்டிருக்க வேண்டும்.
5. Build → Build Bundle(s) / APK(s) → Build APK(s).
6. APK பொதுவாக `app/build/outputs/apk/debug/app-debug.apk` இடத்தில் கிடைக்கும்.

குறிப்பு: Android Studio/Gradle உங்கள் கணினியில் முதல் முறை dependencies-ஐ download செய்ய internet தேவைப்படும்.
