load("@rules_jvm_external//:defs.bzl", "maven_install")

def load_pmd_dependencies():
    maven_install(
        name = "rules_pmd_dependencies",
        artifacts = [
            "net.sourceforge.pmd:pmd-cli:7.2.0",
            "net.sourceforge.pmd:pmd-java:7.2.0",
        ],
        repositories = [
            "https://repo1.maven.org/maven2",
            "https://repo.maven.apache.org/maven2/",
        ],
        maven_install_json = "@rules_pmd//:rules_pmd_dependencies_install.json",
    )
