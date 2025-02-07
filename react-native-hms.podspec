require "json"

package = JSON.parse(File.read(File.join(__dir__, "package.json")))
sdkVersions = JSON.parse(File.read(File.join(__dir__, "sdk-versions.json")))

Pod::Spec.new do |s|
  s.name         = "react-native-hms"
  s.version      = package["version"]
  s.summary      = package["description"]
  s.homepage     = package["homepage"]
  s.license      = package["license"]
  s.authors      = package["author"]

  s.platforms    = { :ios => "12.0" }
  s.source       = { :git => "https://github.com/100mslive/100ms-react-native.git", :tag => "#{s.version}" }

  s.source_files = "ios/**/*.{h,m,mm,swift}"

  s.dependency "React-Core"
  s.dependency "HMSSDK", sdkVersions["ios"]
  s.dependency 'HMSBroadcastExtensionSDK', '0.0.5'
end
