load("@rules_java//java:defs.bzl", "java_binary")

java_binary(
    name = "wrapper",
    srcs = glob(["src/main/java/**/*.java"]),
    javacopts = ["-Werror"],
    main_class = "io.buildfoundation.bazel.pmd.Main",
    visibility = ["//visibility:public"],
    deps = [
        "@rules_pmd_dependencies//:info_picocli_picocli",
        "@rules_pmd_dependencies//:net_sourceforge_pmd_pmd_cli",
        "@rules_pmd_dependencies//:net_sourceforge_pmd_pmd_core",
        "@rules_pmd_dependencies//:net_sourceforge_pmd_pmd_java",
    ],
)
