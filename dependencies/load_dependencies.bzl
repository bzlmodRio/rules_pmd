load("@rules_jvm_external//:defs.bzl", "maven_install")
load("@rules_jvm_external//:repositories.bzl", "rules_jvm_external_deps")

def load_pmd_dependencies():
    rules_jvm_external_deps()
    maven_install(
        name = "rules_pmd_dependencies",
        artifacts = [
            "net.sourceforge.pmd:pmd-core:6.55.0",
            "net.sourceforge.pmd:pmd-dist:6.55.0",
        ],
        repositories = [
            "https://repo1.maven.org/maven2",
            "https://repo.maven.apache.org/maven2/",
        ],
        maven_install_json = "@rules_pmd//:rules_pmd_dependencies_install.json",
    )
