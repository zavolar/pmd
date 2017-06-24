/**
 * BSD-style license; for more info see http://pmd.sourceforge.net/license.html
 */
/* Generated By:JJTree: Do not edit this line. ASTAnnotationTypeDeclaration.java */

package net.sourceforge.pmd.lang.java.ast;

public class ASTAnnotationTypeDeclaration extends AbstractJavaAccessTypeNode implements ASTAnyTypeDeclaration {

    QualifiedName qualifiedName;

    public ASTAnnotationTypeDeclaration(int id) {
        super(id);
    }

    public ASTAnnotationTypeDeclaration(JavaParser p, int id) {
        super(p, id);
    }

    /**
     * Accept the visitor.
     */
    public Object jjtAccept(JavaParserVisitor visitor, Object data) {
        return visitor.visit(this, data);
    }

    public boolean isNested() {
        return jjtGetParent() instanceof ASTClassOrInterfaceBodyDeclaration
            || jjtGetParent() instanceof ASTAnnotationTypeMemberDeclaration;
    }

    @Override
    public QualifiedName getQualifiedName() {
        if (qualifiedName == null) {
            if (isNested()) {
                ASTAnyTypeDeclaration parent = this.getFirstParentOfType(ASTAnyTypeDeclaration.class);
                QualifiedName parentQN = parent.getQualifiedName();
                qualifiedName = QualifiedName.makeNestedClassOf(parentQN, this.getImage());
                return qualifiedName;
            }

            qualifiedName = QualifiedName.makeOuterClassOf(this);
        }

        return qualifiedName;
    }

    @Override
    public TypeKind getTypeKind() {
        return TypeKind.ANNOTATION;
    }
}
