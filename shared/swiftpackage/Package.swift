// swift-tools-version:5.5
import PackageDescription

let package = Package(
    name: "KMM",
    platforms: [
        .iOS(.v13)
    ],
    products: [
        .library(
            name: "KMM",
            targets: ["KMM"]
        ),
    ],
    targets: [
        .binaryTarget(
            name: "KMM",
            path: "./KMM.xcframework"
        ),
    ]
)
