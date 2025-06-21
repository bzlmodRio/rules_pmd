from bazelrio_gentool.generate_styleguide_rule import StyleguideGroup


def get_pmd_group():
    version = "7.2.0"
    patch = ".bcr1"

    group = StyleguideGroup(
        short_name="pmd",
        is_java=True,
        repo_name="rules_pmd",
        version=version,
        year=1,
        maven_url="",
        patch=patch,
    )
    group.create_java_dependency(
        name="Placeholder",
        group_id="Placeholder",
        parent_folder="Placeholder",
        maven_deps=[
            ("net.sourceforge.pmd:pmd-java", version),
            ("net.sourceforge.pmd:pmd-cli", version),
        ],
    )
    return group
